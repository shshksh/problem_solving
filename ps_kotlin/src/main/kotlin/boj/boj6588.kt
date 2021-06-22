package boj

import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val flag = BooleanArray(1000001) { true }

    for (i in 2..sqrt(1000000.toDouble()).toInt()) {
        if (i >= 2) {
            var tmp = i + i
            while (tmp <= 1000000) {
                flag[tmp] = false
                tmp += i
            }
        }
    }
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0)
            break
        for (i in 3 .. flag.lastIndex) {
            if (flag[i] && flag[n - i]) {
                bw.write("$n = $i + ${n - i}\n")
                break
            }
        }
    }
    bw.flush()
}