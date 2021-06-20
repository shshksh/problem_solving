package boj

import kotlin.math.sqrt

fun main() {
    val bw = System.out.bufferedWriter()

    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val flag = BooleanArray(n + 1) { true }
    flag[1] = false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (i >= 2) {
            var tmp = i + i
            while (tmp <= n ) {
                flag[tmp] = false
                tmp += i
            }
        }
    }

    for (i in m until flag.size) {
        if (flag[i])
            bw.write("$i\n")
    }

    bw.flush()
}