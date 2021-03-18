package programmers.skill_checks.level1

import kotlin.math.sqrt

fun solution(nums: IntArray): Int {
    var answer = 0

    for (i in 0 until nums.size - 2) {
        for (j in i+1 until nums.size - 1) {
            for (k in j+1 until nums.size) {
                println("$i $j $k")
                if (isPrime(nums[i] + nums[j] + nums[k]))
                    answer++
            }
        }
    }

    return answer
}

fun isPrime(sum: Int): Boolean {
    val limit = sqrt(sum.toDouble()).toInt()

    for (i in 2..limit) {
        if (sum % i == 0)
            return false
    }
    return true
}

fun main() {
    println(solution(intArrayOf(1,2,3,4)))
    println(solution(intArrayOf(1,2,7,6,4)))
}