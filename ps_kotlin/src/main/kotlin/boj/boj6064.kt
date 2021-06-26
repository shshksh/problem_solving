package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    for (i in 1..t) {
        val (m, n, x, y) = br.readLine().split(" ").map { it.toLong() }
        val step = m - n
        var count = 0L
        var init = if (x > n) x % n else x
        if (init == 0L)
            init += n
        val limit = init

        while (step != 0L && init != y) {
            count++
            init = (init + step) % n
            if (init <= 0) init += n

            if (init == limit) break
        }

        if (init == y) {
            bw.write("${count * m + x}\n")
        } else {
            bw.write("-1\n")
        }
    }
    bw.flush()
}