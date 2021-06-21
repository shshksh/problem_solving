package boj

fun main() {
    val board = Array(9) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    fun getRemainNumber(i: Int, j: Int): List<Int> {
        val flag = BooleanArray(10) { true }
        for (index in 0..8) {
            flag[board[i][index]] = false
            flag[board[index][j]] = false
        }
        val remain = mutableListOf<Int>()
        for (index in 1..9) {
            if (flag[index])
                remain += index
        }
        return remain
    }

    fun isInSquare(i: Int, j: Int): Boolean {
        val count = IntArray(10)
        val (rowIdx, colIdx) = i / 3 * 3 to j / 3 * 3
        for (ri in rowIdx..rowIdx + 2) {
            for (ci in colIdx..colIdx + 2) {
                count[board[ri][ci]]++
                if (board[ri][ci] > 0 && count[board[ri][ci]] > 1)
                    return false
            }
        }
        return true
    }

    fun dfs(index: Int): Boolean {
        if (index == 81)
            return true
        val (i, j) = index / 9 to index % 9
        if (board[i][j] == 0) {
            val remain = getRemainNumber(i, j)

            for (number in remain) {
                board[i][j] = number
                if (isInSquare(i, j)) {
                    if (dfs(index + 1))
                        return true
                }
                board[i][j] = 0
            }
            return false
        }
        return dfs(index + 1)
    }

    dfs(0)
    for (row in board) {
        println(row.joinToString(" "))
    }
}