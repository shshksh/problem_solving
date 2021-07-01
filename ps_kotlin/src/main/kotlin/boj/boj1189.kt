package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val (r, c, k) = br.readLine().split(" ").map { it.toInt() }
    val visit = Array(r) {
        val line = br.readLine()
        BooleanArray(c) { line[it] != '.' }
    }
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun dfs(x: Int, y: Int, n: Int): Int {
        if (x < 0 || y < 0 || x >= r || y >= c || visit[x][y] || n > k)
            return 0
        if (x == 0 && y == c - 1 && n == k)
            return 1
        var sum = 0
        for (dir in 0..3) {
            visit[x][y] = true
            sum += dfs(x + dx[dir], y + dy[dir], n + 1)
            visit[x][y] = false
        }
        return sum
    }
    println(dfs(r - 1, 0, 1))
}