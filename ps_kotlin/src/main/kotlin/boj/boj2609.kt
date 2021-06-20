package boj

fun main() {
    val (x, y) = readLine()!!.split(" ").map { it.toInt() }
    val gcd = gcdOf(x, y)
    println(gcd)
    println(x * y / gcd)
}

fun gcdOf(x: Int, y: Int): Int {
    if (y == 0)
        return x
    return gcdOf(y, x % y)
}
