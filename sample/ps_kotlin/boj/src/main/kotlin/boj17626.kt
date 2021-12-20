import kotlin.math.abs
import kotlin.math.round
import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    val minSquare = IntArray(n + 1) { it }
    for (i in 1..n) {
        if (abs(sqrt(i.toDouble()) - round(sqrt(i.toDouble()))) < 1e-9) {
            minSquare[i] = 1
        } else {
            var j = 1
            while (j * j <= i) {
                minSquare[i] =
                    minOf(minSquare[i], minSquare[i - j * j] + minSquare[j * j])
                j++
            }
        }
    }
    println(minSquare[n])
}
