package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()

    for (i in 1..t) {
        var count = 0
        val (col, row, cnt) = br.readLine().split(" ").map { it.toInt() }
        val field = Array(row) { BooleanArray(col) }
        for (j in 1..cnt) {
            val (y, x) = br.readLine().split(" ").map { it.toInt() }
            field[x][y] = true
        }
        for (x in field.indices) {
            for (y in field[0].indices) {
                if (field[x][y]) {
                    count++
                    dfs(field, x, y)
                }
            }
        }
        bw.write("$count\n")
    }
    bw.flush()
}

private fun dfs(field: Array<BooleanArray>, x: Int, y: Int) {
    if (x < 0 || y < 0 || x >= field.size || y >= field[0].size || !field[x][y])
        return
    field[x][y] = false
    dfs(field, x - 1, y)
    dfs(field, x, y + 1)
    dfs(field, x + 1, y)
    dfs(field, x, y - 1)
}
