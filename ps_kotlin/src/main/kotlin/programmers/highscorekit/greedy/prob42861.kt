package programmers.highscorekit.greedy

import java.util.*

fun solution(n: Int, costs: Array<IntArray>): Int {

    val startMap = costs.groupBy({ it[0] }, { it[1] to it[2] }).toMutableMap()
    val endMap = costs.groupBy({ it[1] }, { it[0] to it[2] })

    for ((endPoint, list) in endMap) {
        startMap[endPoint] = startMap.getOrPut(endPoint) { listOf() } + list
    }

    val edgeQ = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }
    val visitedSet = mutableSetOf(0)
    edgeQ.addAll(startMap[0]!!)

    var answer = 0

    while (visitedSet.size != n) {
        var minWeightEdge = edgeQ.poll()
        while (minWeightEdge.first in visitedSet) {
            minWeightEdge = edgeQ.poll()
        }

        answer += minWeightEdge.second
        visitedSet.add(minWeightEdge.first)
        edgeQ.addAll(startMap[minWeightEdge.first]!!)
    }

    return answer
}

fun main() {
    println(solution(4, arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(0, 2, 2),
        intArrayOf(1, 2, 5),
        intArrayOf(1, 3, 1),
        intArrayOf(2, 3, 8)
    )))
}