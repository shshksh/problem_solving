package boj

fun main() {
    readLine()!!
    val str = readLine()!!
    val weights = LongArray(50)
    for (i in weights.indices) {
        if (i == 0)
            weights[i] = 1
        else
            weights[i] = weights[i - 1] * 31 % 1234567891
    }

    var hash = 0L
    for ((i, v) in str.withIndex()) {
        hash += (v.toInt() - 96) * weights[i]
    }

    println(hash % 1234567891)
}