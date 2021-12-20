fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val maze = Array(n) { br.readLine().toCharArray() }
    val visit = Array(n) { BooleanArray(m) }

    var step = 0
    val q = ArrayDeque<Pair<Int, Int>>()
    q.addLast(0 to 0)
    visit[0][0] = true

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    loop@ while (q.isNotEmpty()) {
        val size = q.size
        step++

        for (j in 1..size) {
            val curr = q.removeFirst()

            if (curr.first == n - 1 && curr.second == m - 1)
                break@loop

            for (i in 0..3) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if (x < 0 || y < 0 || x >= n || y >= m || visit[x][y] || maze[x][y] == '0')
                    continue
                visit[x][y] = true
                q.addLast(x to y)
            }
        }
    }
    println(step)
}
