package boj

import java.util.*
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")
    val chemicals = LongArray(n) { st.nextToken().toLong() }
    var (left, right) = 0 to 1
    var (lp, rp) = 0 to n - 1

    while (lp < rp) {
        val sum = chemicals[lp] + chemicals[rp]
        if (abs(sum) <= abs(chemicals[left] + chemicals[right])) {
            left = lp
            right = rp
        }
        if (sum < 0)
            lp++
        else
            rp--
    }

    println("${chemicals[left]} ${chemicals[right]}")
}
