package algorithm.dp

//val fibMemo = mutableListOf(0, 1)
//
//fun fib(n: Int): Int {
//    if (n < 2 || fibMemo.getOrNull(n) != null)
//        return fibMemo[n]
//    fibMemo.add(n, fib(n - 1) + fib(n - 2))
//    return fibMemo[n]
//}

fun fib(n: Int): Int {
    if (n < 2)
        return n
    var acc = 0 to 1

    for (i in 2..n)
        acc = acc.second to acc.first + acc.second

    return acc.second
}

fun main() {
    for (i in 0..10) {
        println(fib(i))
    }
}
