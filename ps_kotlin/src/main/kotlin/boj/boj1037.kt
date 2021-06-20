package boj

fun main() {
    readLine()!!
    var (min, max) = Int.MAX_VALUE to 0
    readLine()!!.split(" ").map { it.toInt() }.forEach {
        min = minOf(min, it)
        max = maxOf(max, it)
    }
    println(min * max)
}