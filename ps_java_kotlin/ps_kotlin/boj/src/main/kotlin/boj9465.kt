import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val t = br.readLine().toInt()
    for (i in 1..t) {
        val n = br.readLine().toInt()
        val dp = Array(2) {
            val st = StringTokenizer(br.readLine())
            IntArray(n + 1) { j -> if (j > 0) st.nextToken().toInt() else 0 }
        }

        for (j in 2..n) {
            dp[0][j] = maxOf(dp[1][j - 1], dp[1][j - 2]) + dp[0][j]
            dp[1][j] = maxOf(dp[0][j - 1], dp[0][j - 2]) + dp[1][j]
        }

        println(maxOf(dp[0][n], dp[1][n]))
    }
}
