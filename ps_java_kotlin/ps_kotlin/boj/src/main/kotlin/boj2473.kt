import java.util.*
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")
    val chemicals = LongArray(n) { st.nextToken().toLong() }.sorted()
    val result = IntArray(3)
    var nearest = Long.MAX_VALUE

    for (left in 0 until chemicals.size - 2) {
        var mid = left + 1
        var right = chemicals.lastIndex
        val target = -chemicals[left]

        while (mid < right) {
            val sum = chemicals[mid] + chemicals[right]

            if (abs(sum - target) < nearest) {
                nearest = abs(sum - target)
                result[0] = left
                result[1] = mid
                result[2] = right
            }

            if (sum < target) {
                mid++
            } else {
                right--
            }
        }
    }

    println(result.joinToString(" ") { "${chemicals[it]}" })
}
