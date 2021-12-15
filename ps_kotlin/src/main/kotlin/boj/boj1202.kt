package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val jewels = Array(n) {
        val st = StringTokenizer(br.readLine(), " ")
        IntArray(2) { st.nextToken().toInt() }
    }

    val backpacks = IntArray(k) { br.readLine().toInt() }

    jewels.sortWith(compareBy { it[0] })
    backpacks.sort()

    val q = PriorityQueue<Int> { o1, o2 -> o2 - o1 }

    var sum = 0L

    var index = 0

    for (backpack in backpacks) {
        while (index < jewels.size && jewels[index][0] <= backpack) {
            q.offer(jewels[index++][1])
        }
        if (q.isNotEmpty())
            sum += q.poll()
    }

    println(sum)
}
