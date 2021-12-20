import java.util.*
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val poly = Array(n + 1) { LongArray(2) }
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        poly[i][0] = st.nextToken().toLong()
        poly[i][1] = st.nextToken().toLong()
    }
    poly[n] = poly[0]

    var result = 0L
    for (i in 0 until n) {
        result += poly[i][0] * poly[i + 1][1]
        result -= poly[i][1] * poly[i + 1][0]
    }

    println(String.format("%.1f", abs(result / -2.0)))
}
