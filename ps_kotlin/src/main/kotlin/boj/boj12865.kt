package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, w) = br.readLine().split(" ").map { it.toInt() }
    val items = Array(n) { br.readLine().split(" ").map { it.toInt() } }

    val dp = Array(n + 1) { IntArray(w + 1) }
    for (i in 1..n) {
        for (j in 1..w) {
            dp[i][j] = dp[i - 1][j]
            if (j >= items[i - 1][0])
                dp[i][j] =
                    maxOf(dp[i][j], dp[i - 1][j - items[i - 1][0]] + items[i - 1][1])
        }
    }
    println(dp[n][w])
}