package algorithm.greedy

import java.util.*

fun leastInterval(tasks: CharArray, n: Int): Int {
    val counter = mutableMapOf<Char, Int>()
    for (task in tasks) {
        counter[task] = counter.getOrDefault(task, 0) + 1
    }

    val q = PriorityQueue<Int>(Comparator { o1, o2 -> o2 - o1 })
    for ((_, v) in counter) {
        q.add(v)
    }
    var t = 0
    var result = 0

    while (t < tasks.size) {
        val remain = mutableListOf<Int>()
        var i = 0
        while (i <= n && t < tasks.size) {
            val process = q.poll()
            if (process != null) {
                if (process > 1)
                    remain.add(process - 1)
                t++
            }
            i++
            result++
        }
        q.addAll(remain)
    }

    return result
}

fun main() {
    println(leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2))
    println(leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 0))
    println(
        leastInterval(
            charArrayOf(
                'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'
            ), 2
        )
    )
    println(
        leastInterval(
            charArrayOf(
                'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D'
            ), 1
        )
    )
    println(
        leastInterval(
            charArrayOf(
                'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D'
            ), 2
        )
    )
    println(
        leastInterval(
            charArrayOf(
                'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D'
            ), 3
        )
    )
    println(
        leastInterval(
            charArrayOf(
                'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D'
            ), 4
        )
    )
}
