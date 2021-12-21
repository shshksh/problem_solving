fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }

    fun powOf(a: Long, b: Long, c: Long): Long {
        if (b == 1L)
            return a % c
        val half = powOf(a, b / 2, c)
        return if (b % 2 == 0L) {
            (half * half) % c
        } else {
            ((half * half) % c * a) % c
        }
    }

    println(powOf(a % c, b, c))
}
