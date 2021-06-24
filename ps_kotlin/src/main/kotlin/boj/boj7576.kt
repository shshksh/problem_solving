package boj

import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = System.`in`.bufferedReader()

    val q = ArrayDeque<Pair<Int, Int>>()
    var fresh = 0

    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val box = Array(n) { i ->
        val st = StringTokenizer(br.readLine(), " ")
        IntArray(m) { j ->
            val tomato = st.nextToken().toInt()
            if (tomato == 0)
                fresh++
            else if (tomato == 1)
                q.addLast(i to j)
            tomato
        }
    }

    if (fresh == 0) {
        println(0)
        return
    }

    var days = -1
    while (q.isNotEmpty()) {
        val size = q.size
        days++
        for (i in 1..size) {
            val (x, y) = q.poll()

            for (j in 0..3) {
                val xx = x + dx[j]
                val yy = y + dy[j]
                if (isInbound(box, xx, yy) && box[xx][yy] == 0) {
                    fresh--
                    box[xx][yy] = 1
                    q.addLast(xx to yy)
                }
            }
        }
    }

    if (fresh == 0) {
        println(days)
    } else {
        println(-1)
    }
}

private fun isInbound(box: Array<IntArray>, xx: Int, yy: Int): Boolean {
    if (xx < 0 || yy < 0 || xx >= box.size || yy >= box[0].size)
        return false
    return true
}
