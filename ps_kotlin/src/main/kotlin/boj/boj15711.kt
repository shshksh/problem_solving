package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()

    val flag = BooleanArray(2000001) { true }
    flag[1] = false
    val primes = ArrayDeque<Int>()

    for (i in 2..2000000) {
        if (i >= 2) {
            if (flag[i])
                primes.addLast(i)
            else
                continue
            for (j in i + i..2000000 step i)
                flag[j] = false
        }
    }

    fun isPrime(p: Long): Boolean {
        if (p <= 2000000) return flag[p.toInt()]
        else {
            for (prime in primes) {
                if (p % prime == 0L)
                    return false
            }
            return true
        }
    }

    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toLong() }
        val sum = a + b

        if (sum < 4L) {
            bw.write("NO\n")
        } else if (sum % 2 == 0L) {
            bw.write("YES\n")
        } else {
            if (isPrime(sum - 2)) bw.write("YES\n")
            else bw.write("NO\n")
        }
    }
    bw.flush()
}