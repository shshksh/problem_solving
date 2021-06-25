package boj

import java.util.*

fun main() {
    val bw = System.out.bufferedWriter()
    val n = readLine()!!.toInt()
    val st = StringTokenizer(readLine(), " ")
    val order = IntArray(n) { st.nextToken().toInt() }
    val index = order.distinct().sorted().withIndex().associate { (i, v) -> v to i }
    for (i in order) {
        bw.write("${index[i]} ")
    }
    bw.flush()
}