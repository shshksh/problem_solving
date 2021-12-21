import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val t = br.readLine().toInt()

    val n = br.readLine().toInt()
    val dpA = Array(n) { LongArray(n) }
    val counterA = mutableMapOf<Long, Long>()
    StringTokenizer(br.readLine(), " ").let { st ->
        for (i in 0 until n) {
            dpA[0][i] = st.nextToken().toLong()
            if (i > 0) {
                dpA[0][i] += dpA[0][i - 1]
            }
            counterA[dpA[0][i]] = counterA.getOrDefault(dpA[0][i], 0) + 1
        }
    }

    val m = br.readLine().toInt()
    val dpB = Array(m) { LongArray(m) }
    val counterB = mutableMapOf<Long, Long>()
    StringTokenizer(br.readLine(), " ").let { st ->
        for (i in 0 until m) {
            dpB[0][i] = st.nextToken().toLong()
            if (i > 0) {
                dpB[0][i] += dpB[0][i - 1]
            }
            counterB[dpB[0][i]] = counterB.getOrDefault(dpB[0][i], 0) + 1
        }
    }

    for (i in 1 until n) {
        for (j in i until n) {
            dpA[i][j] = dpA[0][j] - dpA[0][i - 1]
            counterA[dpA[i][j]] = counterA.getOrDefault(dpA[i][j], 0) + 1
        }
    }
    for (i in 1 until m) {
        for (j in i until m) {
            dpB[i][j] = dpB[0][j] - dpB[0][i - 1]
            counterB[dpB[i][j]] = counterB.getOrDefault(dpB[i][j], 0) + 1
        }
    }

    var result = 0L

    for ((k, v) in counterA) {
        result += v * counterB.getOrDefault(t - k, 0)
    }

    println(result)
}
