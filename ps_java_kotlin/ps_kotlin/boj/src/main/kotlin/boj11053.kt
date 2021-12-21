fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }

    val dp = IntArray(n + 1) { 1 }
    var result = 0

    for (i in 1..n) {
        for (j in 1..i) {
            if (arr[i - 1] > arr[j - 1]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
        result = maxOf(result, dp[i])
    }
    println(result)
}
/*
27
7 6 5 4 3 2 1 7 8 9 2 7 8 9 3 7 8 9 4 7 8 9 5 7 8 9 10
 */
