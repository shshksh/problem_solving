import java.io.BufferedReader
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val tc = br.readLine().toInt()

    for (i in 1..tc) {
        val (n, k) = tokenize(2, br)
        val buildTime = intArrayOf(0) + tokenize(n, br)
        val dependencies = Array(n + 1) { mutableListOf<Int>() }

        for (j in 1..k) {
            val (prev, next) = tokenize(2, br)
            dependencies[next].add(prev)
        }

        val target = br.readLine().toInt()

        val dp = Array<Int?>(n + 1) { null }

        fun calcBuildTime(target: Int): Int {
            var result = dp[target]
            if (result != null) return result

            var max = 0
            for (dependency in dependencies[target]) {
                max = maxOf(max, calcBuildTime(dependency))
            }
            result = max + buildTime[target]

            dp[target] = result

            return result
        }

        println(calcBuildTime(target))
    }

}

private fun tokenize(n: Int, br: BufferedReader): IntArray {
    val st = StringTokenizer(br.readLine(), " ")
    return IntArray(n) { st.nextToken().toInt() }
}
