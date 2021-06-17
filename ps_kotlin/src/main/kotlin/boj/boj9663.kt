package boj

import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val board = IntArray(n + 1)

    println(nQueen(board, 1))
}

fun nQueen(board: IntArray, index: Int): Int {
    if (index == board.size)
        return 1
    var result = 0
    for (i in 1 until board.size) {
        if (isValid(board, index, i)) {
            board[index] = i
            result += nQueen(board, index + 1)
            board[index] = 0
        }
    }
    return result
}

fun isValid(board: IntArray, index: Int, value: Int): Boolean {
    for (i in 1 until index) {
        if (board[i] == value || abs(board[i] - value) == abs(index - i))
            return false
    }
    return true
}
