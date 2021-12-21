fun main() {
    val br = System.`in`.bufferedReader()
    val target = mutableListOf<Int>()

    val board = Array(9) { row ->
        val line = br.readLine()
        IntArray(9) { column ->
            if (line[column] == '0')
                target.add(row * 9 + column)
            line[column].digitToInt()
        }
    }

    fun isPossible(x: Int, y: Int): Boolean {
        val check = BooleanArray(10)
        for (column in 0..8) {
            if (board[x][column] == 0)
                continue
            if (check[board[x][column]])
                return false
            check[board[x][column]] = true
        }
        check.fill(false)
        for (row in 0..8) {
            if (board[row][y] == 0)
                continue
            if (check[board[row][y]])
                return false
            check[board[row][y]] = true
        }
        check.fill(false)

        for (row in (x / 3) * 3 until (x / 3 + 1) * 3) {
            for (column in (y / 3) * 3 until (y / 3 + 1) * 3) {
                if (board[row][column] == 0)
                    continue
                if (check[board[row][column]])
                    return false
                check[board[row][column]] = true
            }
        }
        return true
    }

    fun dfs(index: Int): Boolean {
        if (index == target.size)
            return true
        val x = target[index] / 9
        val y = target[index] % 9

        for (i in 1..9) {
            board[x][y] = i
            if (!isPossible(x, y))
                continue

            val result = dfs(index + 1)
            if (result)
                return result
        }
        board[x][y] = 0
        return false
    }

    dfs(0)

    println(board.joinToString("\n") { it.joinToString("") })
}
