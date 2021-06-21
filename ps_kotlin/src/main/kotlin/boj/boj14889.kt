package boj

import java.lang.Math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val stats = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    var diff = Int.MAX_VALUE

    fun calcStat(list: List<Int>): Int {
        var sum = 0
        for (i in list.indices) {
            for (j in i + 1 until list.size) {
                sum += stats[list[i]][list[j]]
                sum += stats[list[j]][list[i]]
            }
        }
        return sum
    }

    fun dfs(index: Int, list: List<Int>) {
        if (list.size == n / 2) {
            val other = (0 until n).filter { it !in list }
            diff = minOf(diff, abs(calcStat(list) - calcStat(other)))
            return
        }
        for (i in index + 1 until stats.size) {
            dfs(i, list + i)
        }
    }

    dfs(0, listOf())
    println(diff)
}