package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val link = br.readLine().toInt()

    val graph = mutableMapOf<Int, MutableList<Int>>()
    repeat(link) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableListOf() }.add(b)
        graph.getOrPut(b) { mutableListOf() }.add(a)
    }
    val visited = BooleanArray(n + 1)
    visited[1] = true
    val q = ArrayDeque<Int>()
    q.addLast(1)

    var count = 0
    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        for (next in graph.getValue(node)) {
            if (!visited[next]) {
                count++
                visited[next] = true
                q.addLast(next)
            }
        }
    }

    println(count)
}