import java.util.*

private const val R = 0
private const val G = 1
private const val B = 2

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val rCase = Array(n) { IntArray(3) { 1000001 } }
    val gCase = Array(n) { IntArray(3) { 1000001 } }
    val bCase = Array(n) { IntArray(3) { 1000001 } }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        val (r, g, b) = IntArray(3) { st.nextToken().toInt() }

        if (i == 0) {
            rCase[i][R] = r
            gCase[i][G] = g
            bCase[i][B] = b
        } else {
            if (i != n - 1) {
                dp(rCase, i, r, g, b)
                dp(gCase, i, r, g, b)
                dp(bCase, i, r, g, b)
            } else {
                dp(rCase, i, 1000001, g, b)
                dp(gCase, i, r, 1000001, b)
                dp(bCase, i, r, g, 1000001)
            }
        }
    }

    var min = Int.MAX_VALUE
    for (i in 0..2) {
        min = minOf(min, rCase[n - 1][i], gCase[n - 1][i], bCase[n - 1][i])
    }

    println(min)
}

fun dp(case: Array<IntArray>, i: Int, r: Int, g: Int, b: Int) {
    case[i][R] = minOf(case[i][R], case[i - 1][G] + r, case[i - 1][B] + r)
    case[i][G] = minOf(case[i][G], case[i - 1][R] + g, case[i - 1][B] + g)
    case[i][B] = minOf(case[i][B], case[i - 1][R] + b, case[i - 1][G] + b)
}
