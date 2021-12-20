import java.util.*

private val offset = arrayOf(
    intArrayOf(-1, 0, 1, 0),
    intArrayOf(0, 1, 0, -1)
)

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n) { IntArray(m) }
    var count = 0

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 0 until m) {
            map[i][j] = st.nextToken().toInt()
            if (map[i][j] == 1)
                count++
        }
    }

    var time = 0

    while (count != 0) {
        time++
        checkOutside(map, 0, 0, time + 1)
        count -= melt(map, time + 1)
    }

    println(time)
}

fun checkOutside(map: Array<IntArray>, x: Int, y: Int, mark: Int) {
    if (x < 0 || x >= map.size || y < 0 || y >= map[0].size || map[x][y] == 1 || map[x][y] == mark)
        return
    map[x][y] = mark
    for (i in 0..3) {
        checkOutside(map, x + offset[0][i], y + offset[1][i], mark)
    }
}

fun melt(map: Array<IntArray>, mark: Int): Int {
    var removed = 0
    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] == 1) {
                var count = 0
                for (k in 0..3) {
                    if (map[i + offset[0][k]][j + offset[1][k]] == mark)
                        count++
                }
                if (count >= 2) {
                    map[i][j] = 0
                    removed++
                }
            }
        }
    }
    return removed
}
