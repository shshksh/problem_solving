package nonlinear.shortest_path

import java.util.*
import kotlin.math.min

fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
    val graph = times.groupBy { it[0] }
    val check = BooleanArray(N + 1)
    val q = PriorityQueue<IntArray> { o1, o2 -> o1[2] - o2[2] }
    val weights = MutableList(N + 1) { Int.MAX_VALUE }
    weights[K] = 0

    q.offer(intArrayOf(-1, K, 0))
    while (!q.isEmpty()) {
        val current = q.poll()
        if (check[current[1]])
            continue
        check[current[1]] = true
        for (edge in graph.getOrDefault(current[1], listOf())) {
            if (!check[edge[1]]) {
                weights[edge[1]] = min(weights[edge[1]], weights[current[1]] + edge[2])
                q.offer(intArrayOf(edge[0], edge[1], weights[edge[1]]))
            }
        }
    }

    if (check.drop(1).all { it }) {
        return weights.drop(1).maxOrNull() ?: -1
    }
    return -1
}

fun main() {
    println(
        networkDelayTime(
            arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(2, 3, 2),
                intArrayOf(1, 3, 2)
            ), 3, 1
        )
    )
}
