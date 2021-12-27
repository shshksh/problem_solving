import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val memories = StringTokenizer(br.readLine(), " ").let { st ->
        IntArray(n) { st.nextToken().toInt() }
    }
    val costs = StringTokenizer(br.readLine(), " ").let { st ->
        IntArray(n) { st.nextToken().toInt() }
    }

    val dp = Array(n + 1) { LongArray(costs.sum() + 1) }

    var result = Int.MAX_VALUE

    for (i in 0 until n) {
        for (costLimit in dp[0].indices) {
            if (costs[i] > costLimit) {
                dp[i + 1][costLimit] = dp[i][costLimit]
            } else {
                dp[i + 1][costLimit] =
                    maxOf(dp[i][costLimit], dp[i][costLimit - costs[i]] + memories[i])
            }
            if (dp[i + 1][costLimit] >= m) {
                result = minOf(result, costLimit)
            }
        }
    }

    println(result)
}
