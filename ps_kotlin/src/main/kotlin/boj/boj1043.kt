package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val known = br.readLine().split(" ").map { it.toInt() }
    val parties = Array(m) { br.readLine().split(" ").map { it.toInt() } }
    val graph = Array(n + 1) { BooleanArray(n + 1) }

    for (party in parties) {
        val people = party[0]
        for (i in 1..people)
            for (j in 1..people) {
                graph[party[i]][party[j]] = true
                graph[party[j]][party[i]] = true
            }
    }

    val visit = BooleanArray(n + 1)
    val q = ArrayDeque<Int>()
    for (i in 1 until known.size) {
        visit[known[i]] = true
        q.addLast(known[i])
    }

    while (q.isNotEmpty()) {
        val person = q.removeLast()

        for ((i, b) in graph[person].withIndex()) {
            if (b && !visit[i]) {
                visit[i] = true
                q.addLast(i)
            }
        }
    }

    var count = 0
    outer@for (party in parties) {
        for (i in 1 until party.size) {
            if (visit[party[i]])
                continue@outer
        }
        count++
    }
    println(count)
}