import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { ArrayDeque<Int>() }

    for (i in 1..m) {
        val st = StringTokenizer(br.readLine(), " ")
        graph[st.nextToken().toInt()].addLast(st.nextToken().toInt())
    }

    val check = BooleanArray(n + 1)
    check[0] = true

    val result = ArrayDeque<Int>()

    fun dfs(node: Int) {
        check[node] = true
        for (adj in graph[node]) {
            if (!check[adj])
                dfs(adj)
        }
        result.addFirst(node)
    }

    for (i in 1..n) {
        if (!check[i])
            dfs(i)
    }

    println(result.joinToString(" "))
}
