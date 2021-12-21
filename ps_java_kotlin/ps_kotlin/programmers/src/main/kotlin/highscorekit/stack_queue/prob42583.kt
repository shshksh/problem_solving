package highscorekit.stack_queue

import java.util.*

fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var time = 0
    var truckNumber = 0
    var weightSum = 0

    val q = LinkedList<Pair<Int, Int>>()

    do {
        if (q.isNotEmpty() && q.peek().first == time)
            weightSum -= q.poll().second

        if (truckNumber < truck_weights.size && weightSum + truck_weights[truckNumber] <= weight) {
            q.offer(time + bridge_length to truck_weights[truckNumber])
            weightSum += truck_weights[truckNumber]
            truckNumber++
        }

        time++
    } while (q.isNotEmpty())

    return time
}

fun main() {
    println(solution(2, 10, intArrayOf(7, 4, 5, 6)))
    println(solution(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
}
