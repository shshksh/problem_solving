package boj

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    if (n >= k) {
        println(n - k)
        return
    }

    val visited = mutableSetOf<Int>()
    val q = ArrayDeque<Int>()
    q.add(k)
    var time = 0
    while (q.isNotEmpty()) {
        time++
        val size = q.size
        for (i in 1..size) {
            val location = q.removeFirst()
            if (location == n) {
                q.clear()
                break
            }
            checkAndGo(visited, location - 1, q)
            checkAndGo(visited, location + 1, q)
            if (location % 2 == 0) {
                checkAndGo(visited, location / 2, q)
            }
        }
    }
    println(time - 1)
}

private fun checkAndGo(visited: MutableSet<Int>, location: Int, q: ArrayDeque<Int>) {
    if (location !in visited) {
        visited.add(location)
        q.addLast(location)
    }
}
