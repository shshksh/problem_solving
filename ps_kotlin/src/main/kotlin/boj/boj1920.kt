package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted()

    val m = br.readLine().toInt()
    val target = br.readLine().split(" ").map { it.toInt() }

    val result = Array(m) { if(arr.binarySearch(target[it]) >= 0) "1" else "0" }

    for (r in result) {
        bw.write(r)
        bw.newLine()
    }
    bw.flush()
}