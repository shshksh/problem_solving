fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toLong()
    val mod = 1_000_000_007L
    var sum = 0L

    for (i in 1..n) {
        var (a, b) = br.readLine().split(" ").map { it.toLong() }
        val gcd = gcd(a, b)
        a /= gcd
        b /= gcd

        val inverse = pow(a, mod - 2, mod)
        sum += (b * inverse % mod)
    }
    println(sum % mod)
}

fun pow(a: Long, exp: Long, mod: Long): Long {
    if (exp == 1L)
        return a
    val result = pow(a, exp / 2, mod) % mod
    return if (exp % 2 == 0L)
        result * result % mod
    else
        (result * result % mod) * a % mod
}

private fun gcd(a: Long, b: Long): Long {
    if (b == 0L)
        return a
    return gcd(b, a % b)
}
