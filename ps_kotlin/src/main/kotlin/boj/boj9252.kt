package boj

private const val UP = 1
private const val LEFT = 2
private const val CROSS = 3

fun main() {
    val br = System.`in`.bufferedReader()

    val st1 = br.readLine()
    val st2 = br.readLine()

    val dp = Array(st1.length + 1) { IntArray(st2.length + 1) }
    val dir = Array(st1.length + 1) { IntArray(st2.length + 1) }

    for (i in 0..st1.length) {
        for (j in 0..st2.length) {
            dp[i][j] = if (i == 0 || j == 0) {
                0
            } else if (st1[i - 1] == st2[j - 1]) {
                dir[i][j] = CROSS
                dp[i - 1][j - 1] + 1
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    dir[i][j] = UP
                } else {
                    dir[i][j] = LEFT
                }
                maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    val result = dp[st1.length][st2.length]
    println(result)
    if (result != 0) {
        val st = mutableListOf<Char>()
        var (i, j) = st1.length to st2.length

        while (dp[i][j] != 0) {
            if (dir[i][j] == CROSS) {
                st.add(st1[i - 1])
                i--
                j--
            } else if (dir[i][j] == UP) {
                i--
            } else if (dir[i][j] == LEFT) {
                j--
            }
        }

        println(st.reversed().joinToString(""))
    }
}
