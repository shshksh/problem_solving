fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val field = Array(n) { br.readLine().toCharArray() }
    val visit = Array(n) { BooleanArray(n) }

    var count = 0
    val result = mutableListOf<Int>()

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun dfs(x: Int, y: Int): Int {
        if (x < 0 || y < 0 || x >= n || y >= n || field[x][y] == '0' || visit[x][y])
            return 0

        visit[x][y] = true
        var sum = 0
        for (i in 0..3) {
            sum += dfs(x + dx[i], y + dy[i])
        }
        return 1 + sum
    }

    for (x in field.indices) {
        for (y in field[0].indices) {
            if (!visit[x][y] && field[x][y] == '1') {
                count++
                result += dfs(x, y)
            }
        }
    }
    bw.write("$count\n")
    for (blob in result.sorted()) {
        bw.write("$blob\n")
    }
    bw.flush()
}
