import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

const val APPLE = 1
const val SNAKE = 2

fun main() {
    val offset = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1)
    )

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val appleCount = br.readLine().toInt()

    // initialize board
    val board = Array(n + 1) { Array(n + 1) { 0 } }

    // put apple on board
    for (i in 1..appleCount) {
        val pos = br.readLine().split(" ")
        board[pos[0].toInt()][pos[1].toInt()] = APPLE
    }
    board[1][1] = SNAKE

    val dirQ = LinkedList<Pair<Int, String>>()
    val dirCount = br.readLine().toInt()
    for (i in 1..dirCount) {
        val dir = br.readLine().split(" ")
        dirQ.offer(dir[0].toInt() to dir[1])
    }

    val snake = Snake(1, 1)
    var second = 0
    while (true) {
        second++

        val (nextX, nextY) = snake.x + offset[snake.dir][0] to snake.y + offset[snake.dir][1]
        if (!isValid(board, nextX, nextY))
            break

        if (board[nextX][nextY] == APPLE) {
            snake.inc(board, nextX, nextY)
        } else {
            snake.mov(board, nextX, nextY)
        }

        if (dirQ.isNotEmpty() && second == dirQ.peek().first) {
            when (dirQ.poll().second) {
                "D" -> snake.dir = (snake.dir + 1) % 4
                "L" -> snake.dir = (snake.dir + 3) % 4
            }
        }

    }

    println(second)
}

class Snake(var x: Int, var y: Int, var dir: Int = 1) {
    val snakeQ = LinkedList<Pair<Int, Int>>()

    init {
        snakeQ.offer(1 to 1)
    }

    fun inc(board: Array<Array<Int>>, nextX: Int, nextY: Int) {
        snakeQ.offer(nextX to nextY)
        board[nextX][nextY] = SNAKE
        x = nextX
        y = nextY
    }

    fun mov(board: Array<Array<Int>>, nextX: Int, nextY: Int) {
        snakeQ.offer(nextX to nextY)
        board[nextX][nextY] = SNAKE
        val (tx, ty) = snakeQ.poll()
        board[tx][ty] = 0
        x = nextX
        y = nextY
    }

}

fun isValid(board: Array<Array<Int>>, x: Int, y: Int): Boolean =
    x > 0 && y > 0 && x < board.size && y < board.size && board[x][y] != SNAKE
