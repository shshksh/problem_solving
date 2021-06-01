package boj

/*
Source: 백준 1753 최단경로(https://www.acmicpc.net/problem/1753)
Solved: O
Approach: 다익스트라.
Review:
- 다수 오답과 메모리 초과가 발생하여 수정했지만 이전 코드와 다른 점을 찾지 못하겠음. 우선순위 큐에 Vertex
를 넣는것과 edge로 사용하는 Pair를 넣는점이 다르고 알고리즘은 동일한데 맞다고 나오니 찝찝하다.
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
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

data class Vertex(
    val number: Int,
    val edges: MutableList<Pair<Int, Int>>?,
    var weight: Int,
)

fun boj1753(vertexCount: Int, startVertex: Int, edges: Array<IntArray>) {

    val graph =
        Array(vertexCount + 1) { Vertex(it, mutableListOf(), Int.MAX_VALUE) }
    edges.forEach {
        graph[it[0]].edges?.add(it[1] to it[2])
    }

    val q = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }
    q.offer(startVertex to 0)
    val visit = BooleanArray(vertexCount + 1)

    while (q.isNotEmpty()) {
        val edge = q.poll() ?: continue
        if (visit[edge.first])
            continue
        visit[edge.first] = true
        graph[edge.first].weight = edge.second

        graph[edge.first].edges?.forEach { e ->
            if (!visit[e.first]) {
                val adj = graph[e.first]
                val w = minOf(adj.weight, graph[edge.first].weight + e.second)
                q.offer(e.first to w)
            }
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(vertexCount) {
        val w = graph[it + 1].weight

        if (w == Int.MAX_VALUE)
            bw.write("INF\n")
        else
            bw.write("$w\n")
    }
    bw.flush()
}