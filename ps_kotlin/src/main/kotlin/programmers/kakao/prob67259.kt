package programmers.kakao
/*
실패 (시간 초과)
 */

class Prob67259DFS {
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun solution(board: Array<IntArray>): Int {

        var min = 0x7fffffff
        val visit = Array(board.size) { BooleanArray(board.size) }

        fun dfs(x: Int, y: Int, acc: Int, dir: Int) {
            if (x < 0 || y < 0 || x >= board.size || y >= board.size || acc >= min || board[x][y] == 1 || visit[x][y])
                return
            if (x == board.size - 1 && y == board.size - 1) {
                min = minOf(min, acc)
                return
            }
            for (i in 0..3) {
                visit[x][y] = true
                if (i == dir) {
                    dfs(x + dx[i], y + dy[i], acc + 100, dir)
                } else {
                    dfs(x + dx[i], y + dy[i], acc + 600, i)
                }
                visit[x][y] = false
            }
        }

        dfs(0, 0, -500, -1)

        return min
    }
}

class Prob67259BFS {
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun solution(board: Array<IntArray>): Int {

        var min = 0x7fffffff
        val visit = Array(board.size) { IntArray(board.size) }

        val q = ArrayDeque<List<Int>>()
        q.addLast(listOf(0, 0, -1, 0))

        while (q.isNotEmpty()) {
            val (x, y, dir, cost) = q.removeFirst()
            if (x < 0 || y < 0 || x >= board.size || y >= board.size)
                continue
            if (board[x][y] == 1 || visit[x][y] < cost)
                continue
            if (x == board.size - 1 && y == board.size - 1) {
                min = minOf(min, cost)
                continue
            }
            visit[x][y] = cost

            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (dir == i)
                    q.addLast(listOf(nx, ny, i, cost + 100))
                else
                    q.addLast(listOf(nx, ny, i, cost + 600))
            }
        }

        return min
    }
}