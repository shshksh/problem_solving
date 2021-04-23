package programmers.skill_checks.highscorekit.stack_queue

import kotlin.math.ceil

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var completeDays = progresses.mapIndexed { index, progress ->
        ceil((100 - progress).toDouble() / speeds[index]).toInt()
    }

    val result = mutableListOf<Int>()

    while (completeDays.isNotEmpty()) {
        val tasks = completeDays.takeWhile { it <= completeDays[0] }.size
        result.add(tasks)
        completeDays = completeDays.drop(tasks)
    }

    return result.toIntArray()
}

fun main() {
    println(solution(intArrayOf(95, 90, 99, 99, 80, 99),
        intArrayOf(1, 1, 1, 1, 1, 1)).contentToString())
}