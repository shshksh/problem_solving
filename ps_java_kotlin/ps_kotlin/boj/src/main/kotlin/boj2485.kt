fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var diffSum = 0
    var curr = br.readLine().toInt()
    var gcd = 0

    repeat(n - 1) {
        val next = br.readLine().toInt()
        diffSum += next - curr
        gcd = gcd(gcd, next - curr)
        curr = next
    }

    println(diffSum / gcd - n + 1)
}

private fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
