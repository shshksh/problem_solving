package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, e) = br.readLine().split(" ").map { it.toInt() }
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

    for (i in 1..e) {
        val (a, b, w) = br.readLine().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableListOf() }.add(b to w)
        graph.getOrPut(b) { mutableListOf() }.add(a to w)
    }
    val (a, b) = br.readLine().split(" ").map { it.toInt() }

    val route1 = pathOf(n, graph, 1)
    val routeA = pathOf(n, graph, a)
    val routeB = pathOf(n, graph, b)

    if (route1[n] == Int.MAX_VALUE)
        println(-1)
    else {
        val result =
            minOf(route1[a] + routeA[b] + routeB[n], route1[b] + routeB[a] + routeA[n])
        println(result)
    }
}

fun pathOf(
    size: Int,
    graph: MutableMap<Int, MutableList<Pair<Int, Int>>>,
    start: Int
): IntArray {
    class Node(val number: Int, val weight: Int)

    val result = IntArray(size + 1) { Int.MAX_VALUE }
    val visit = BooleanArray(size + 1)
    val q = PriorityQueue<Node> { o1, o2 -> o1.weight - o2.weight }

    q.offer(Node(start, 0))
    result[start] = 0

    while (q.isNotEmpty()) {
        var curr = q.poll()
        while (curr != null && visit[curr.number])
            curr = q.poll()
        if (curr == null)
            break
        visit[curr.number] = true

        for (node in graph[curr.number] ?: emptyList()) {
            if (!visit[node.first]) {
                result[node.first] = minOf(result[node.first], curr.weight + node.second)
                q.offer(Node(node.first, result[node.first]))
            }
        }
    }
    return result
}