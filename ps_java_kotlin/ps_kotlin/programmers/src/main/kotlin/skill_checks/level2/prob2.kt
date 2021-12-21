package skill_checks.level2

fun solution(citations: IntArray): Int {
    citations.sort()
    var count = 0
    for (i in citations.size - 1 downTo 0) {
        count++
        if (citations[i] < count)
            return count - 1
    }
    return count
}

fun main() {
    println(solution(intArrayOf(3, 0, 6, 1, 5)))
    println(solution(intArrayOf(0, 0, 1, 1, 5, 5)))
    println(solution(intArrayOf(0, 0, 1, 1, 5, 5, 5)))
    println(solution(intArrayOf(0, 0, 1, 1, 2, 2)))
    println(solution(intArrayOf(0, 1, 2, 3)))
    println(solution(intArrayOf(0, 7, 7)))
    println(solution(intArrayOf(0, 7, 7, 8, 8)))
    println(solution(intArrayOf(0, 10, 5, 3, 4, 6, 5, 7)))
    println(solution(intArrayOf(0)))
    println(solution(intArrayOf(1)))
    println(solution(intArrayOf(2)))
    println(solution(intArrayOf(3)))
    println(solution(intArrayOf(4)))
    println(solution(intArrayOf(5,4,3)))
    println(solution(intArrayOf(5,2,2,0,0)))
    println(solution(intArrayOf(5,5,5,5)))
}
