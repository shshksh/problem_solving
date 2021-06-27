package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val graph = mutableMapOf<Int, MutableList<Int>>()

    for (i in 1 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableListOf() }.add(b)
        graph.getOrPut(b) { mutableListOf() }.add(a)
    }
    val visit = IntArray(n + 1) { -1 }
    val q = ArrayDeque<Int>()
    q.add(1)

    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        val adj = graph[node] ?: emptyList()

        for (next in adj) {
            if (visit[next] == -1) {
                visit[next] = node
                q.addLast(next)
            }
        }
    }

    for (i in 2..n) {
        bw.write("${visit[i]}\n")
    }
    bw.flush()
}