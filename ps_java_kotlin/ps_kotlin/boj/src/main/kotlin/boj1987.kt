private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = System.`in`.bufferedReader()

    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(r) { br.readLine() }
    val check = BooleanArray(26)

    var max = 0

    fun dfs(x: Int, y: Int, acc: Int) {
        if (x !in board.indices || y !in board[0].indices) return
        if (check[board[x][y] - 'A']) return

        check[board[x][y] - 'A'] = true

        max = maxOf(max, acc)

        for (i in 0..3) {
            val xx = x + dx[i]
            val yy = y + dy[i]

            dfs(xx, yy, acc + 1)
        }

        check[board[x][y] - 'A'] = false
    }

    dfs(0, 0, 1)

    println(max)
}
