import java.util.*
import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()

    val tc = br.readLine().toInt()
    for (i in 1..tc) {
        val n = br.readLine().toInt()
        val points = Array(n) {
            val st = StringTokenizer(br.readLine(), " ")
            IntArray(2) { st.nextToken().toInt() }
        }

        println(comb(intArrayOf(), points, 0))
    }
}

private fun comb(chosen: IntArray, points: Array<IntArray>, n: Int): Double {
    if (chosen.size == points.size / 2) {
        val intersect = points.indices.filter { it !in chosen }
        var (x, y) = 0.0 to 0.0

        for (i in chosen.indices) {
            x += points[chosen[i]][0]
            x -= points[intersect[i]][0]
            y += points[chosen[i]][1]
            y -= points[intersect[i]][1]
        }
        return sqrt(x * x + y * y)
    }
    var min = Double.MAX_VALUE
    for (i in n until points.size) {
        min = minOf(min, comb(chosen + i, points, i + 1))
    }
    return min
}
