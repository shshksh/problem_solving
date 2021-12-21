package nonlinear.shortest_path

import java.util.*

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
    val graph = flights.groupBy { it[0] }
    val q = PriorityQueue<IntArray> { o1, o2 -> o1[2] - o2[2] }

    q.offer(intArrayOf(-1, src, 0, 0))
    while (!q.isEmpty()) {
        val (_, _dst, weight, times) = q.poll()
        if (_dst == dst) {
            return weight
        }
        if (times <= K) {
            for (edge in graph.getOrDefault(_dst, listOf())) {
                q.offer(intArrayOf(edge[0], edge[1], weight + edge[2], times + 1))
            }
        }
    }

    return -1
}
