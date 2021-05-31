package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (vertexCount, edgeCount) = br.readLine().split(" ").map { it.toInt() }
    val startVertex = br.readLine().toInt()
    val edges = Array(edgeCount) {
        br.readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()
    }

    boj1753(vertexCount, startVertex, edges)
}

data class Vertex(val number: Int, val edges: MutableList<Vertex>, var weight: Int)

fun boj1753(vertexCount: Int, startVertex: Int, edges: Array<IntArray>) {

    val graph = mutableMapOf<Int, Vertex>()
    repeat(vertexCount) {
        graph[it + 1] = Vertex(it + 1, mutableListOf(), Int.MAX_VALUE)
    }
    edges.forEach {
        graph.getOrPut(it[0]) { Vertex(it[0], mutableListOf(), Int.MAX_VALUE) }
            .edges
            .add(Vertex(it[1], mutableListOf(), it[2]))
    }

    val q = PriorityQueue<Vertex> { o1, o2 -> o1.weight - o2.weight }
    graph[startVertex]?.weight = 0
    q.offer(graph[startVertex])
    val visit = BooleanArray(vertexCount + 1)

    while (q.isNotEmpty()) {
        val v = getNextVertex(q, visit)
        v?.let {
            visit[v.number] = true

            v.edges.forEach { e ->
                if (!visit[e.number]) {
                    val adj = graph[e.number]!!
                    adj.weight = minOf(adj.weight, v.weight + e.weight)
                    q.offer(adj)
                }
            }
        }
    }

    val sb = StringBuilder()
    repeat(vertexCount) {
        graph[it + 1]?.weight?.let { w ->
            if (w == Int.MAX_VALUE)
                sb.append("INF").appendLine()
            else
                sb.append(w).appendLine()
        }
    }
    println(sb.toString())
}

fun getNextVertex(q: PriorityQueue<Vertex>, visit: BooleanArray): Vertex? {
    while (q.isNotEmpty()) {
        q.poll()?.let {
            if (!visit[it.number])
                return it
        }
    }
    return null
}
