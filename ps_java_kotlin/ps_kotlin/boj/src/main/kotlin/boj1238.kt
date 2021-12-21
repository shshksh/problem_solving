import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m, x) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val inverted = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    for (i in 1..m) {
        val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
        graph[from].add(to to weight)
        inverted[to].add(from to weight)
    }

    val fromX = calcDistance(graph, x)
    val toX = calcDistance(inverted, x)

    var max = 0
    for (i in 1..n) {
        max = maxOf(max, fromX[i] + toX[i])
    }
    println(max)
}

private fun calcDistance(graph: Array<MutableList<Pair<Int, Int>>>, x: Int): IntArray {
    class Node(val to: Int, val weight: Int)

    val distance = IntArray(graph.size) { graph.size * 100 + 1 }
    val check = BooleanArray(graph.size)
    val q = PriorityQueue<Node> { o1, o2 -> o1.weight - o2.weight }
    distance[x] = 0

    q.offer(Node(x, 0))

    while (q.isNotEmpty()) {
        val node = q.poll() ?: continue
        if (check[node.to]) continue

        check[node.to] = true

        for ((to, weight) in graph[node.to]) {
            if (check[to]) continue
            if (distance[to] > distance[node.to] + weight) {
                distance[to] = distance[node.to] + weight
                q.offer(Node(to, distance[to]))
            }
        }
    }

    return distance
}
