import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (y, x, z) = br.readLine().split(" ").map { it.toInt() }
    val q = ArrayDeque<Triple<Int, Int, Int>>()
    val dx = intArrayOf(-1, 0, 1, 0, 0, 0)
    val dy = intArrayOf(0, 1, 0, -1, 0, 0)
    val dz = intArrayOf(0, 0, 0, 0, 1, -1)
    var fresh = 0

    val box = Array(z) { h ->
        Array(x) { r ->
            val st = StringTokenizer(br.readLine())
            IntArray(y) { c ->
                val token = st.nextToken().toInt()
                if (token == 1) q.addLast(Triple(h, r, c))
                else if (token == 0) fresh++
                token
            }
        }
    }

    var days = 0

    while (fresh > 0 && q.isNotEmpty()) {
        val size = q.size
        days++

        for (i in 1..size) {
            val curr = q.removeFirst()

            for (j in 0..5) {
                val (h, r, c) = Triple(
                    curr.first + dz[j],
                    curr.second + dx[j],
                    curr.third + dy[j]
                )
                if (h < 0 || r < 0 || c < 0 || h >= z || r >= x || c >= y || box[h][r][c] != 0)
                    continue
                box[h][r][c] = 1
                q.addLast(Triple(h, r, c))
                fresh--
            }
        }
    }

    if (fresh == 0) println(days) else println(-1)
}
