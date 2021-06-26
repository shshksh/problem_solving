package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, String>()
    repeat(n) {
        val param = br.readLine().split(" ")
        map[param[0]] = param[1]
    }
    repeat(m) {
        bw.write("${map.getValue(br.readLine())}\n")
    }
    bw.flush()
}