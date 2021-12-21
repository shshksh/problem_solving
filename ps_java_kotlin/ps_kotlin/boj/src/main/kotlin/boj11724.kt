fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = mutableMapOf<Int, MutableList<Int>>()
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableListOf() }.add(b)
        graph.getOrPut(b) { mutableListOf() }.add(a)
    }
    val visited = BooleanArray(n + 1)
    var cc = 0

    for (i in 1..n) {
        if (visited[i])
            continue
        cc++
        val q = ArrayDeque<Int>()
        q.add(i)

        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            graph[node]?.let {
                for (j in graph[node]!!) {
                    if (!visited[j]) {
                        visited[j] = true
                        q.addLast(j)
                    }
                }
            }
        }
    }
    println(cc)
}
