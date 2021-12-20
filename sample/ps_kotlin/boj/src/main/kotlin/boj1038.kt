import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    descendingNumberAt(n)
}

private fun descendingNumberAt(_n: Int) {
    var n = _n
    when {
        n <= 10 -> println(n)
        n > 1022 -> println(-1)
        else -> {
            var descendingNumber = 10L

            while (n-- > 10) {
                descendingNumber = nextDescendingNumber(descendingNumber)
            }

            println(descendingNumber)
        }
    }
}

fun nextDescendingNumber(descendingNumber: Long): Long {
    val sb = StringBuilder((descendingNumber + 1).toString())
    var index = sb.lastIndex
    while (index > 0 && sb[index] == sb[index - 1]) {
        sb[index] = if (index == sb.lastIndex) '0' else nextCharOf(sb[index + 1])
        sb[index - 1] = nextCharOf(sb[index - 1])
        index--
    }
    if (!isDescending(sb.toString(), sb.lastIndex))
        return newDescendingNumber(sb.length, "0")
    return sb.toString().toLong()
}

fun isDescending(number: String, lastIndex: Int): Boolean {
    for (i in 0 until lastIndex) {
        if (number[i] <= number[i + 1])
            return false
    }
    return true
}

fun newDescendingNumber(length: Int, s: String): Long {
    if (length == 0)
        return s.toLong()
    return newDescendingNumber(length - 1, nextCharOf(s.first()) + s)
}

fun nextCharOf(c: Char) = when (c) {
    '0' -> '1'
    '1' -> '2'
    '2' -> '3'
    '3' -> '4'
    '4' -> '5'
    '5' -> '6'
    '6' -> '7'
    '7' -> '8'
    '8' -> '9'
    '9' -> '0'
    else -> throw IllegalArgumentException()
}
