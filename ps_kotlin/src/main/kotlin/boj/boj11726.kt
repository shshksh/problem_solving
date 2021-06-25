package boj

fun main() {
    val n = readLine()!!.toInt()

    val fibo = IntArray(n + 2)
    fibo[1] = 1
    fibo[2] = 2
    for (i in 3..n) {
        fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 10007
    }
    println(fibo[n])
}