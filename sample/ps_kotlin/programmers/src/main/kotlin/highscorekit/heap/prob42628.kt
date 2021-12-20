package highscorekit.heap

import java.util.*

fun solution(operations: Array<String>): IntArray {
    val maxQ = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    val minQ = PriorityQueue<Int> { o1, o2 -> o1 - o2 }

    for (operation in operations) {
        when {
            operation.startsWith("I") -> {
                val value = operation.split(" ")[1].toInt()
                maxQ.offer(value)
                minQ.offer(value)
            }
            operation == "D 1" -> {
                val maxValue = maxQ.poll()
                if (maxValue != null)
                    minQ.remove(maxValue)
            }
            operation == "D -1" -> {
                val minValue = minQ.poll()
                if (minValue != null)
                    maxQ.remove(minValue)
            }
        }
    }

    if (maxQ.isEmpty())
        return intArrayOf(0, 0)
    return intArrayOf(maxQ.poll(), minQ.poll())
}
