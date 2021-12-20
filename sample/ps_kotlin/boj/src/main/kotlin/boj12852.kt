fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)
    val prev = IntArray(n + 1)

    for (i in n - 1 downTo 1) {
        dp[i] = dp[i + 1] + 1
        prev[i] = i + 1

        if (i * 2 <= n && dp[i * 2] < dp[i + 1]) {
            dp[i] = dp[i * 2] + 1
            prev[i] = i * 2
        }

        if (i * 3 <= n && dp[i * 3] < dp[i + 1] && dp[i * 3] < dp[i * 2]) {
            dp[i] = dp[i * 3] + 1
            prev[i] = i * 3
        }
    }

    bw.write("${dp[1]}")
    bw.newLine()

    val stack = mutableListOf<Int>()
    var curr = 1
    while (true) {
        stack.add(curr)
        if (curr == n) break
        curr = prev[curr]
    }
    while (stack.isNotEmpty()) {
        bw.write("${stack.last()} ")
        stack.removeLast()
    }
    bw.flush()
}
