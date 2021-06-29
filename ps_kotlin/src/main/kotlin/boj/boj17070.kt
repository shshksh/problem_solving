package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val house = Array(n + 1) {

        IntArray(n + 1)
    }
    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        for (j in 1..n)
            house[i][j] = st.nextToken().toInt()
    }
    val dp = Array(n + 1) { Array(n + 1) { IntArray(3) } }

    dp[1][2][0] = 1

    for (i in 1..n) {
        for (j in 3..n) {
            if (house[i][j] == 0) {
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
            }
            if (house[i][j] == 0 && house[i - 1][j] == 0 && house[i][j - 1] == 0)
                dp[i][j][2] =
                    dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
        }
    }
    println(dp[n][n].sum())
}