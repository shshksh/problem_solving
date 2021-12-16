package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val edges = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    for (i in 1..m) {
        val st = StringTokenizer(br.readLine(), " ")
        val (from, to, weight) = IntArray(3) { st.nextToken().toInt() }

        edges[from].add(to to weight)
        edges[to].add(from to weight)
    }

    val check = BooleanArray(n + 1)
    val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    q.offer(1 to 0)

    var sum = 0
    var max = 0

    while (q.isNotEmpty()) {
        val edge = q.poll() ?: continue
        if (check[edge.first]) continue

        check[edge.first] = true
        sum += edge.second
        max = maxOf(max, edge.second)

        for (adj in edges[edge.first]) {
            if (check[adj.first]) continue
            q.offer(adj)
        }
    }

    println(sum - max)
}
