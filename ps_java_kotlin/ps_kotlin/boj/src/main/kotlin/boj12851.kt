fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    if (n >= k) {
        println(n - k)
        println(1)
        return
    }

    var depth = 0
    val q = ArrayDeque<Int>()
    q.add(k)
    val visit = IntArray(100001)
    visit[k] = 1
    val depthArr = IntArray(100001)

    fun go(curr: Int, next: Int, depth: Int) {
        if (visit[next] == 0) {
            visit[next] = visit[curr]
            depthArr[next] = depth
            q.addLast(next)
        } else if (depthArr[next] == depth) {
            visit[next] += visit[curr]
        }
    }

    while (visit[n] == 0) {
        depth++
        val size = q.size
        for (i in 1..size) {
            val location = q.removeFirst()
            if (location > 0)
                go(location, location - 1, depth)
            if (location < 100000)
                go(location, location + 1, depth)
            if (location % 2 == 0)
                go(location, location / 2, depth)
        }
    }
    println(depthArr[n])
    println(visit[n])
}
