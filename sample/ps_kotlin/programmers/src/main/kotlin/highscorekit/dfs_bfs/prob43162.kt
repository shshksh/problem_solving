package highscorekit.dfs_bfs

import java.util.*

fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 0

    val visitedSet = mutableSetOf<Int>()
    for (i in 0 until n) {
        val q = LinkedList<Int>()

        if (i !in visitedSet) {
            q.offer(i)
            answer++
        }
        while (q.isNotEmpty()) {
            var computer = q.poll()
            while (computer in visitedSet)
                computer = q.poll()
            if (computer == null)
                continue
            visitedSet.add(computer)
            for (j in 0 until n) {
                if (computers[computer][j] == 1 && j !in visitedSet)
                    q.offer(j)
            }
        }
    }

    return answer
}

fun main() {
    println(
        solution(3, arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    ))
    )

    println(
        solution(3, arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 1)
    ))
    )

    println(
        solution(5, arrayOf(
        intArrayOf(1, 0, 0, 1, 0),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(0, 0, 0, 0, 1),
    ))
    )

    println(
        solution(5, arrayOf(
        intArrayOf(1, 0, 0, 1, 0),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(0, 0, 1, 0, 1),
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(0, 0, 1, 0, 1),
    ))
    )

}
