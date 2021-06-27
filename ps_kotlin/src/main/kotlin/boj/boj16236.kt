package boj

import java.util.*

private val dx = intArrayOf(-1, 0, 0, 1)
private val dy = intArrayOf(0, -1, 1, 0)

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    var x = -1
    var y = -1
    val field = Array(n) { i ->
        val st = StringTokenizer(br.readLine(), " ")
        IntArray(n) { j ->
            val token = st.nextToken().toInt()
            if (token == 9) {
                x = i
                y = j
            }
            token
        }
    }
    var shark = 2
    var ate = 0
    var time = 0
    field[x][y] = 0

    while (true) {
        val result = bfs(field, x, y, shark)
        if (result.first < 0 || result.second < 0)
            break
        else {
            ate++
            if (ate == shark) {
                shark++
                ate = 0
            }
            x = result.first
            y = result.second
            time += result.third
            field[x][y] = 0
        }
    }
    println(time)
}

private fun bfs(
    field: Array<IntArray>,
    x: Int,
    y: Int,
    shark: Int
): Triple<Int, Int, Int> {
    var q1 = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        if (o1.first == o2.first) o1.second - o2.second
        else o1.first - o2.first
    }
    var q2 = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
        if (o1.first == o2.first) o1.second - o2.second
        else o1.first - o2.first
    }
    q1.offer(x to y)
    val visit = Array(field.size) { BooleanArray(field.size) }
    visit[x][y] = true

    var depth = 0

    while (q1.isNotEmpty()) {
        val size = q1.size

        for (i in 1..size) {
            val curr = q1.poll()

            if (field[curr.first][curr.second] in 1 until shark) {
                return Triple(curr.first, curr.second, depth)
            }

            for (j in 0..3) {
                val xx = curr.first + dx[j]
                val yy = curr.second + dy[j]

                if (xx < 0 || yy < 0 || xx >= field.size || yy >= field.size || visit[xx][yy] || field[xx][yy] > shark)
                    continue
                visit[xx][yy] = true
                q2.offer(xx to yy)
            }
        }
        val tmp = q1
        q1 = q2
        q2 = tmp
        depth++
    }
    return Triple(-1, -1, -1)
}