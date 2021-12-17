package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(br.readLine(), " ")
    val nums = IntArray(n) { st.nextToken().toInt() }

    var i = 0
    var j = 0
    var sum = 0
    var min = 100001

    while (j < nums.size && i <= j) {
        sum += nums[j]

        if (sum >= s) {
            min = minOf(min, j - i + 1)

            while (sum >= s && i <= j) {
                sum -= nums[i++]

                if (sum >= s) {
                    min = minOf(min, j - i + 1)
                }
            }
        }

        j++
    }

    if (min > 100000) {
        println(0)
    } else {
        println(min)
    }
}
