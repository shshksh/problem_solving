fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val grid = Array(n) { br.readLine() }
    val normal = Array(n) { BooleanArray(n) }
    val rg = Array(n) { BooleanArray(n) }

    var cnt1 = 0
    var cnt2 = 0

    fun dfs(i: Int, j: Int, char: Char, flag: Boolean) {
        if (i < 0 || j < 0 || i >= n || j >= n) return
        if (flag) {
            if (normal[i][j] || grid[i][j] != char) return
        } else {
            if (char == 'B') {
                if (rg[i][j] || grid[i][j] != 'B') return
            } else {
                if (rg[i][j] || grid[i][j] == 'B') return
            }
        }
        if (flag) {
            normal[i][j] = true
        } else {
            rg[i][j] = true
        }
        dfs(i - 1, j, char, flag)
        dfs(i, j + 1, char, flag)
        dfs(i + 1, j, char, flag)
        dfs(i, j - 1, char, flag)
    }

    for ((i, row) in grid.withIndex()) {
        for ((j, char) in row.withIndex()) {
            if (!normal[i][j]) {
                cnt1++
                dfs(i, j, char, true)
            }
            if (!rg[i][j]) {
                cnt2++
                dfs(i, j, char, false)
            }
        }
    }
    println("$cnt1 $cnt2")
}
