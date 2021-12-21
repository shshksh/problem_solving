import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    class Vertex(val number: Int, var weight: Int = Int.MAX_VALUE)

    val graph = mutableMapOf<Int, MutableList<Vertex>>()

    for (i in 1..m) {
        val (a, b, w) = br.readLine().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableListOf() }.add(Vertex(b, w))
    }

    val (a, b) = br.readLine().split(" ").map { it.toInt() }

    val visit = BooleanArray(n + 1)
    val q = PriorityQueue<Vertex> { o1, o2 -> o1.weight - o2.weight }
    q.add(Vertex(a, 0))

    while (q.isNotEmpty()) {
        var curr = q.poll()
        while (curr != null && visit[curr.number])
            curr = q.poll()
        if (curr == null)
            break
        if (curr.number == b) {
            println(curr.weight)
            break
        }
        visit[curr.number] = true

        val adj = graph[curr.number] ?: emptyList()

        for (vertex in adj) {
            if (!visit[vertex.number]) {
                q.offer(Vertex(vertex.number, curr.weight + vertex.weight))
            }
        }
    }
}
