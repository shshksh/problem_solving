package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()

    for (i in 1..n + m) {
        val (st, ed) = br.readLine().split(" ")
        map[st.toInt()] = ed.toInt()
    }

    var count = 0
    val q = ArrayDeque<Int>()
    q.addLast(1)
    val visit = BooleanArray(101)
    visit[1] = true

    while (q.isNotEmpty()) {
        val size = q.size
        count++

        for (i in 1..size) {
            val curr = q.removeFirst()

            for (j in 1..6) {
                var next = curr + j
                if (next in map) next = map[next]!!

                if (next == 100) {
                    println(count)
                    return
                }
                if (next < 100 && !visit[next]) {
                    visit[next] = true
                    q.addLast(next)
                }
            }
        }
    }
}