package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val arr = IntArray(20001)
    for (i in 0 until n) {
        arr[br.readLine().toInt() + 10000]++
    }
    for ((i, b) in arr.withIndex()) {
        if (b != 0) {
            repeat(b) {
                bw.write("${i - 10000}\n")
            }
        }
    }
    bw.flush()
}