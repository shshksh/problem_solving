package codinginterview.algorithm.dp

fun climbStairs(n: Int): Int {
    var fibo = 0 to 1

    for (i in 1..n) {
        fibo = fibo.second to fibo.first + fibo.second
    }

    return fibo.second
}

fun main() {
    for (i in 1..45) {
        println(climbStairs(i))
    }
}