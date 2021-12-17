package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val board = Array(8) {
        val st = StringTokenizer(br.readLine(), " ")
        LongArray(8) { st.nextToken().toLong() }
    }
    val commands = br.readLine().split(" ")

    for (command in commands) {
        run(board, command)
    }

    println(board.joinToString("\n") { it.joinToString(" ") })
}

private fun run(board: Array<LongArray>, command: String) {
    when (command) {
        "U" -> {
            for (col in board.indices) {
                val column = mutableListOf<Long>()
                var i = 0
                for (row in board.indices) {
                    if (board[row][col] > 0) {
                        if (i >= column.size)
                            column.add(board[row][col])
                        else if (column[i] == board[row][col]) {
                            column[i] = column[i] * 2
                            i++
                        } else {
                            column.add(board[row][col])
                            i++
                        }
                    }
                }

                val iter = column.iterator()
                for (row in board.indices) {
                    if (iter.hasNext()) {
                        board[row][col] = iter.next()
                    } else {
                        board[row][col] = 0
                    }
                }
            }
        }
        "D" -> {
            for (col in board.indices) {
                val column = mutableListOf<Long>()
                var i = 0
                for (row in board.indices.reversed()) {
                    if (board[row][col] > 0) {
                        if (i >= column.size)
                            column.add(board[row][col])
                        else if (column[i] == board[row][col]) {
                            column[i] = column[i] * 2
                            i++
                        } else {
                            column.add(board[row][col])
                            i++
                        }
                    }
                }

                val iter = column.iterator()
                for (row in board.indices.reversed()) {
                    if (iter.hasNext()) {
                        board[row][col] = iter.next()
                    } else {
                        board[row][col] = 0
                    }
                }
            }
        }
        "L" -> {
            for (row in board.indices) {
                val column = mutableListOf<Long>()
                var i = 0
                for (col in board.indices) {
                    if (board[row][col] > 0) {
                        if (i >= column.size)
                            column.add(board[row][col])
                        else if (column[i] == board[row][col]) {
                            column[i] = column[i] * 2
                            i++
                        } else {
                            column.add(board[row][col])
                            i++
                        }
                    }
                }

                val iter = column.iterator()
                for (col in board.indices) {
                    if (iter.hasNext()) {
                        board[row][col] = iter.next()
                    } else {
                        board[row][col] = 0
                    }
                }
            }
        }
        "R" -> {
            for (row in board.indices) {
                val column = mutableListOf<Long>()
                var i = 0
                for (col in board.indices.reversed()) {
                    if (board[row][col] > 0) {
                        if (i >= column.size)
                            column.add(board[row][col])
                        else if (column[i] == board[row][col]) {
                            column[i] = column[i] * 2
                            i++
                        } else {
                            column.add(board[row][col])
                            i++
                        }
                    }
                }

                val iter = column.iterator()
                for (col in board.indices.reversed()) {
                    if (iter.hasNext()) {
                        board[row][col] = iter.next()
                    } else {
                        board[row][col] = 0
                    }
                }
            }
        }
    }
}
