package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val arr = BooleanArray(2000001)
    for (i in 0 until n) {
        arr[br.readLine().toInt() + 1000000] = true
    }
    for ((i, b) in arr.withIndex()) {
        if (b)
            bw.write("${i - 1000000}\n")
    }
    bw.flush()
}