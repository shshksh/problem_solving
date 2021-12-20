fun main() {
    val br = System.`in`.bufferedReader()

    val tc = br.readLine().toInt()

    for (i in 1..tc) {
        val (n, m, w) = br.readLine().split(" ").map { it.toInt() }

        val edge = mutableListOf<Triple<Int, Int, Int>>()

        for (j in 1..m) {
            val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
            edge.add(Triple(from, to, weight))
            edge.add(Triple(to, from, weight))
        }
        for (j in 1..w) {
            val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
            edge.add(Triple(from, to, -weight))
        }

        if (bf(edge, n)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun bf(edge: MutableList<Triple<Int, Int, Int>>, n: Int): Boolean {
    val distance = IntArray(n + 1) { n * 10000 * 2 + 1 }
    distance[1] = 0

    for (i in 1 until n) {
        for ((from, to, weight) in edge) {
            if (distance[to] > distance[from] + weight) {
                distance[to] = distance[from] + weight
            }
        }
    }
    for ((from, to, weight) in edge) {
        if (distance[to] > distance[from] + weight) {
            return true
        }
    }
    return false
}
