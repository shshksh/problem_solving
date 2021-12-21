import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    val flag = BooleanArray(n + 1) { true }
    flag[1] = false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (i >= 2) {
            var tmp = i + i
            while (tmp <= n) {
                flag[tmp] = false
                tmp += i
            }
        }
    }

    val primes = mutableListOf<Int>()
    for (i in 2 until flag.size) {
        if (flag[i])
            primes += i
    }

    var count = 0
    for (i in primes.indices) {
        var sum = 0
        if (primes[i] > n / 2)
            break
        for (j in i until primes.size) {
            sum += primes[j]
            if (sum == n) {
                count++
            } else if (sum > n) {
                break
            }
        }
    }
    if (n in primes)
        count++

    println(count)
}
