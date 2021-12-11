package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val maxScore = intArrayOf(0, 0, 0)
    val minScore = intArrayOf(0, 0, 0)
    val temp = intArrayOf(0, 0, 0)

    val n = br.readLine().toInt()

    for (i in 1..n) {
        val score = br.readLine().split(" ").map { it.toInt() }

        temp[0] = maxOf(maxScore[0], maxScore[1]) + score[0]
        temp[1] = maxOf(maxScore[0], maxScore[1], maxScore[2]) + score[1]
        temp[2] = maxOf(maxScore[1], maxScore[2]) + score[2]

        maxScore[0] = temp[0]
        maxScore[1] = temp[1]
        maxScore[2] = temp[2]

        temp[0] = minOf(minScore[0], minScore[1]) + score[0]
        temp[1] = minOf(minScore[0], minScore[1], minScore[2]) + score[1]
        temp[2] = minOf(minScore[1], minScore[2]) + score[2]

        minScore[0] = temp[0]
        minScore[1] = temp[1]
        minScore[2] = temp[2]
    }

    println("${maxOf(maxScore[0], maxScore[1], maxScore[2])} ${minOf(minScore[0], minScore[1], minScore[2])}")
}
