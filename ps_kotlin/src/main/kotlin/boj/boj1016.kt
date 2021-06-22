package boj

fun main() {
    val (min, max) = readLine()!!.split(" ").map { it.toLong() }
    val flag = BooleanArray((max - min + 1).toInt()) { true }

    for (i in 2 .. 1000000) {
        val square = i * i.toLong()
        val tmp = min / square * square
        val start = if (tmp == min) 0 else tmp + square - min
        for (j in start until flag.size step square) {
            flag[j.toInt()] = false
        }
    }

    println(flag.count { it })
}