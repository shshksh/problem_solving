package boj

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var bottle = n
    while (bottle.countOneBits() > k) {
        bottle += 1
    }
    println(bottle - n)
}