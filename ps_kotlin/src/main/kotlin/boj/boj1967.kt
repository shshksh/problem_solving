package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    for (i in 1 until n) {
        val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
        graph[from].add(to to weight)
        graph[to].add(from to weight)
    }

    val check = BooleanArray(n + 1)
    var (result, index) = 0 to 0

    fun dfs(node: Int, acc: Int) {
        check[node] = true
        if (graph[node].size == 1) {
            if (acc > result) {
                result = acc
                index = node
            }
        }
        for ((child, weight) in graph[node]) {
            if (check[child]) continue
            dfs(child, acc + weight)
        }
    }
    dfs(1, 0)

    check.fill(false)

    dfs(index, 0)

    println(result)
}
