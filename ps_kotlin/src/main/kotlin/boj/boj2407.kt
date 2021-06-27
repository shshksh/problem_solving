package boj

import java.math.BigInteger

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val dp = Array(n + 1) { Array<BigInteger>(n + 1) { BigInteger.ONE } }

    for (i in 2..n) {
        for (j in 1 until i) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
    }
    println(dp[n][m])
}