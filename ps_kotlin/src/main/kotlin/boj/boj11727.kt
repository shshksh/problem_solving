package boj

fun main() {
    val n = readLine()!!.toInt()
    var (a, b) = 1 to 3
    for (i in 3..n) {
        val tmp = (b + a * 2) % 10007
        a = b
        b = tmp
    }
    if (n == 1) println(1) else println(b)
}