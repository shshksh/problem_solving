package programmers.kakao

fun solution(board: Array<IntArray>, moves: IntArray): Int {

    val bucket = mutableListOf<Int>()

    for (move in moves) {
        for (index in board.indices) {
            if (board[index][move - 1] != 0) {
                bucket.add(board[index][move - 1])
                board[index][move - 1] = 0
                break
            }
        }
    }

    println(bucket)

    return crashBlock(bucket, 0)
}

fun crashBlock(bucket: List<Int>, sum: Int): Int {
    bucket.forEachIndexed { index, block ->
        if (index < bucket.size - 1) {
            if (block == bucket[index + 1])
                return crashBlock(bucket.filterIndexed { j, _ ->
                    j !in index..index + 1
                }, sum + 2)
        }
    }
    return sum
}

fun main() {
    println(solution(arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 3),
        intArrayOf(0, 2, 5, 0, 1),
        intArrayOf(4, 2, 4, 4, 2),
        intArrayOf(3, 5, 1, 3, 1)
    ), intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)))
}