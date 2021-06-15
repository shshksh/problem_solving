package boj

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    repeat(t) {
        val q = ArrayDeque<Int>()
        val command = br.readLine()
        var reverse = false
        br.readLine()
        val st = StringTokenizer(br.readLine(), ",[]")
        while (st.hasMoreTokens()) {
            q.addLast(st.nextToken().toInt())
        }
        for (c in command) {
            if (c == 'R')
                reverse = !reverse
            if (c == 'D') {
                if (q.isEmpty()) {
                    bw.write("error\n")
                    return@repeat
                }
                if (reverse) {
                    q.removeLast()
                } else {
                    q.removeFirst()
                }
            }
        }
        if (reverse) {
            bw.write(q.reversed()
                .joinToString(separator = ",", prefix = "[", postfix = "]\n"))
        } else {
            bw.write(q.joinToString(separator = ",", prefix = "[", postfix = "]\n"))
        }
    }
    bw.flush()
}