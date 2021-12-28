fun main() {
    val br = System.`in`.bufferedReader()

    val tc = br.readLine().toInt()
    for (t in 1..tc) {
        val n = br.readLine().toInt()
        val students = listOf(0) + br.readLine().split(" ").map { it.toInt() }

        println(solve(n, students))
    }
}

private fun solve(n: Int, students: List<Int>): Int {
    var result = n
    val check = BooleanArray(n + 1)
    val disable = BooleanArray(n + 1)

    for (i in 1..n) {
        if (check[i] || disable[i])
            continue
        var curr = i
        val visited = mutableListOf<Int>()

        while (!check[curr]) {
            check[curr] = true
            visited.add(curr)
            curr = students[curr]
        }

        if (!disable[curr]) {
            val target = curr
            curr = students[curr]
            result--

            while (curr != target) {
                curr = students[curr]
                result--
            }
        }

        for (v in visited) {
            disable[v] = true
        }
    }

    return result
}
