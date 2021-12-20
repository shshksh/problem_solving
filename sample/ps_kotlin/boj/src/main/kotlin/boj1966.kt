fun main() {
    val br = System.`in`.bufferedReader()

    repeat(br.readLine().toInt()) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val priorities = br.readLine().split(" ").map { it.toInt() }
        val order = priorities.sortedDescending()
        var index = 0
        val q = ArrayDeque(priorities.mapIndexed { i, v -> i to v })

        while (q.isNotEmpty()) {
            if (q.first().second == order[index]) {
                val doc = q.removeFirst()
                index++
                if (doc.first == m) {
                    println(index)
                    break
                }
            } else {
                q.addLast(q.removeFirst())
            }
        }
    }
}
