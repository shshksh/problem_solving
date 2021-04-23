package programmers.highscorekit.stack_queue

import java.util.*

fun solution(priorities: IntArray, location: Int): Int {
    val q = LinkedList<Pair<Int, Int>>()
    q.addAll(priorities.mapIndexed { index, priority -> priority to index })

    val printOrder = priorities.sortedDescending()
    var printCursor = 0

    while (q.isNotEmpty()) {
        if (q.peek().first == printOrder[printCursor]) {
            if (q.peek().second == location)
                break
            q.poll()
            printCursor++
        } else {
            q.offer(q.poll())
        }
    }

    return printCursor + 1
}