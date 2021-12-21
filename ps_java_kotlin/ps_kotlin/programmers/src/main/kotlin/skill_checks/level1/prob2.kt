package skill_checks.level1

fun solution(n: Long): IntArray {
    var value = n
    val answer = mutableListOf<Int>()

    while (value > 0) {
        answer.add((value % 10).toInt())
        value /= 10
    }

    return answer.toIntArray()
}
