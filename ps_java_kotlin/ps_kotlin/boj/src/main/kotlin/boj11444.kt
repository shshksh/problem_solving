fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toLong()

    println(fibo(n)[1])
}

fun fibo(n: Long): LongArray {
    if (n == 1L) return longArrayOf(1, 1, 1, 0)

    val prev = fibo(n / 2)
    return if (n % 2 == 0L) {
        mul(prev, prev)
    } else {
        val tmp = mul(prev, prev)
        mul(tmp, longArrayOf(1, 1, 1, 0))
    }
}

fun mul(op1: LongArray, op2: LongArray) = longArrayOf(
    (op1[0] * op2[0] + op1[1] * op2[2]) % 1000000007,
    (op1[0] * op2[1] + op1[1] * op2[3]) % 1000000007,
    (op1[2] * op2[0] + op1[3] * op2[2]) % 1000000007,
    (op1[2] * op2[1] + op1[3] * op2[3]) % 1000000007
)
