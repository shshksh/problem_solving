package boj

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    if (n >= k) {
        println(n - k)
        return
    }

    val visit = IntArray(100001) { -1 }
    visit[n] = 0
    val q = ArrayDeque<Int>()
    q.addLast(n)
    var depth = 0

    while (visit[k] < 0) {
        val size = q.size

        for (i in 1..size) {
            val curr = q.removeFirst()
            var tmp = curr

            while (tmp in 1..100000) {
                if (visit[tmp] < 0) {
                    visit[tmp] = visit[curr]
                    q.addLast(tmp)
                }
                tmp *= 2
            }
            if (curr > 0 && visit[curr - 1] < 0) {
                visit[curr - 1] = visit[curr] + 1
                q.addLast(curr - 1)
            }
            if (curr < 100000 && visit[curr + 1] < 0) {
                visit[curr + 1] = visit[curr] + 1
                q.addLast(curr + 1)
            }
        }
        depth++
    }
    println(visit[k])
}