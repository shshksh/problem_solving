import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    var (n, m, b) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) {
        val st = StringTokenizer(br.readLine(), " ")
        IntArray(m) { st.nextToken().toInt() }
    }
    var height = map.maxOf { it.maxOf { i -> i } }
    val min = map.minOf { it.minOf { i -> i } }
    var (fillCount, cutCount) = 0 to 0
    var (time, resultHeight) = Int.MAX_VALUE to Int.MAX_VALUE

    while (height >= min) {
        val result = remainFieldOf(map, height)
        fillCount = result.first

        if (fillCount <= b) {
            val _time = cutCount * 2 + fillCount
            if (_time < time) {
                time = _time
                resultHeight = height
            } else
                break
        }

        height--
        b += result.second
        cutCount += result.second
    }

    println("$time $resultHeight")
}

fun remainFieldOf(map: Array<IntArray>, height: Int): Pair<Int, Int> {
    var fillCount = 0
    var cutCount = 0
    for ((i, arr) in map.withIndex()) {
        for ((j, field) in arr.withIndex()) {
            fillCount += height - field
            if (field == height) {
                cutCount++
                map[i][j] -= 1
            }
        }
    }
    return fillCount to cutCount
}
