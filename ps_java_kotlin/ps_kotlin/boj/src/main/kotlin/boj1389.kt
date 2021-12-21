fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = mutableMapOf<Int, MutableList<Int>>()
    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableListOf() }.add(b)
        graph.getOrPut(b) { mutableListOf() }.add(a)
    }

    fun baconOf(start: Int): Int {
        val q = ArrayDeque<Int>()
        q.addLast(start)
        val visit = BooleanArray(n + 1)
        visit[start] = true
        var result = 0
        var breadth = 0

        while (q.isNotEmpty()) {
            val size = q.size
            breadth++

            for (i in 0 until size) {
                val next = q.removeFirst()
                for (j in graph[next]!!) {
                    if (!visit[j]) {
                        visit[j] = true
                        q.addLast(j)
                        result += breadth
                    }
                }
            }
        }
        return result
    }

    var result = 1
    var minNumber = Int.MAX_VALUE

    for (i in 1..n) {
        val number = baconOf(i)
        if (number < minNumber) {
            minNumber = number
            result = i
        }
    }
    println(result)
}
