import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val rgb = Array(n) {
        val st = StringTokenizer(br.readLine(), " ")
        IntArray(3) { st.nextToken().toInt() }
    }

    for (i in 1 until n) {
        rgb[i][0] += minOf(rgb[i-1][1], rgb[i-1][2])
        rgb[i][1] += minOf(rgb[i-1][0], rgb[i-1][2])
        rgb[i][2] += minOf(rgb[i-1][0], rgb[i-1][1])
    }

    println(minOf(minOf(rgb[n-1][0], rgb[n-1][1]), rgb[n-1][2]))
}
