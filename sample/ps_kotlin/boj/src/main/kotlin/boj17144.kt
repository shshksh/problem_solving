import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = System.`in`.bufferedReader()

    val (r, c, t) = br.readLine().split(" ").map { it.toInt() }
    val q = ArrayDeque<Pair<Int, Int>>()

    val map = Array(r) { i ->
        val st = StringTokenizer(br.readLine(), " ")
        IntArray(c) { j ->
            val token = st.nextToken().toInt()
            if (token > 0)
                q.addLast(i to j)
            token
        }
    }
    val after = Array(r) { IntArray(c) }

    for (i in 1..t) {
        val size = q.size

        spread(size, q, map, after)

        mergeMap(map, after)

        move(map)

        for (row in map.indices) {
            for (col in map[0].indices) {
                if (map[row][col] > 0)
                    q.addLast(row to col)
            }
        }
    }
    val sum = map.sumOf { it.sum() }
    println(sum + 2)
}

private fun move(map: Array<IntArray>) {
    val x1 = map.indexOfFirst { it[0] == -1 }
    val x2 = x1 + 1

    for (i in x1 - 1 downTo 1)
        map[i][0] = map[i - 1][0]
    for (i in x2 + 1 until map.size - 1)
        map[i][0] = map[i + 1][0]

    for (i in 0 until map[0].size - 1) {
        map[0][i] = map[0][i + 1]
        map[map.lastIndex][i] = map[map.lastIndex][i + 1]
    }

    for (i in 0 until x1)
        map[i][map[0].lastIndex] = map[i + 1][map[0].lastIndex]
    for (i in map.lastIndex downTo x2 + 1)
        map[i][map[0].lastIndex] = map[i - 1][map[0].lastIndex]

    for (i in map[0].lastIndex downTo 2) {
        map[x1][i] = map[x1][i - 1]
        map[x2][i] = map[x2][i - 1]
    }

    map[x1][1] = 0
    map[x2][1] = 0
}

private fun spread(
    size: Int,
    q: ArrayDeque<Pair<Int, Int>>,
    map: Array<IntArray>,
    after: Array<IntArray>
) {
    for (j in 1..size) {
        val curr = q.removeFirst()

        // 확산
        for (k in 0..3) {
            val x = curr.first + dx[k]
            val y = curr.second + dy[k]

            if (x < 0 || y < 0 || x >= map.size || y >= map[0].size || map[x][y] < 0)
                continue

            val spreadAmount = map[curr.first][curr.second] / 5
            after[x][y] += spreadAmount
            after[curr.first][curr.second] -= spreadAmount
        }
    }
}

fun mergeMap(map: Array<IntArray>, after: Array<IntArray>) {
    for (row in map.indices) {
        for (col in map[0].indices) {
            map[row][col] += after[row][col]
            after[row][col] = 0
        }
    }
}
