package boj

import kotlin.math.pow

fun main() {
    val input = readLine()!!
    boj1405(input)
}

fun boj1405(input: String) {
    val param = input.split(" ")
    val n = param[0].toInt()
    val probability = param.subList(1, param.size).map { it.toDouble() / 100 }
    val offset =
        arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    val map = Array(29) { BooleanArray(29) }

    fun probabilityOf(answer: IntArray): Double {
        return probability[0].pow(answer[0]) *
                probability[1].pow(answer[1]) *
                probability[2].pow(answer[2]) *
                probability[3].pow(answer[3])
    }

    fun dfs(n: Int, x: Int, y: Int, count: IntArray): Double {
        if (map[x][y])
            return probabilityOf(count)
        if (n == 0)
            return 0.0
        var sum = 0.0
        for (i in 0 until 4) {
            count[i]++
            map[x][y] = true
            sum += dfs(n - 1, x + offset[i][0], y + offset[i][1], count)
            map[x][y] = false
            count[i]--
        }
        return sum
    }

    val result = 1 - dfs(n, 14, 14, IntArray(4))
    println(result)
}