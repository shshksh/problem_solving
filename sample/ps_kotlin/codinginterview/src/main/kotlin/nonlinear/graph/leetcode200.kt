package nonlinear.graph

fun numIslands(grid: Array<CharArray>): Int {
    var count = 0

    for (m in grid.indices) {
        for (n in grid[0].indices) {
            if (grid[m][n] == '1') {
                count++
                countLand(grid, m, n)
            }
        }
    }

    return count
}

fun countLand(mGrid: Array<CharArray>, m: Int, n: Int) {
    if (m < 0 || n < 0 || m == mGrid.size || n == mGrid[0].size || mGrid[m][n] == '0')
        return
    mGrid[m][n] = '0'
    countLand(mGrid, m - 1, n)
    countLand(mGrid, m, n + 1)
    countLand(mGrid, m + 1, n)
    countLand(mGrid, m, n - 1)
}

fun main() {
    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '0', '1')
            )
        )
    )
}
