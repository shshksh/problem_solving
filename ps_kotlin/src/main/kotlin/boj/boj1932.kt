package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val dp = Array(n) { IntArray(n) }
    dp[0][0] = br.readLine().toInt()

    for (i in 1 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 0..i) {
            dp[i][j] = st.nextToken().toInt()
            when (j) {
                0 -> dp[i][j] += dp[i - 1][j]
                i -> dp[i][j] += dp[i - 1][i - 1]
                else -> dp[i][j] += maxOf(dp[i - 1][j - 1], dp[i - 1][j])
            }
        }
    }
    var result = 0
    for (i in 0 until n) {
        result = maxOf(result, dp[n - 1][i])
    }
    println(result)
}