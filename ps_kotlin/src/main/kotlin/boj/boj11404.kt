package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val max = 10000001

    val floyd = Array(n) { IntArray(n) { max } }

    for (i in 1..m) {
        val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
        if (floyd[from - 1][to - 1] > weight)
            floyd[from - 1][to - 1] = weight
    }

    for (k in 0 until n)
        for (i in 0 until n)
            for (j in 0 until n)
                if (i != j)
                    floyd[i][j] = minOf(floyd[i][j], floyd[i][k] + floyd[k][j])

    for (i in floyd.indices) {
        for (j in floyd[i].indices) {
            if (floyd[i][j] == max)
                floyd[i][j] = 0
        }
    }

    for (row in floyd) {
        bw.write(row.joinToString(" "))
        bw.newLine()
    }
    bw.flush()
}
