package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, t) = br.readLine().split(" ").map { it.toInt() }
    val table = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 1..n) {
            table[i][j] = table[i - 1][j] +
                    table[i][j - 1] -
                    table[i - 1][j - 1] +
                    st.nextToken().toInt()
        }
    }

    for (i in 1..t) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        val result =
            table[x2][y2] - table[x1 - 1][y2] - table[x2][y1 - 1] + table[x1 - 1][y1 - 1]
        bw.write("$result\n")
    }
    bw.flush()
}