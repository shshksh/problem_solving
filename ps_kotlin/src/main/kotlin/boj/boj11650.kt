package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    List(n) { br.readLine().split(" ").map { it.toInt() } }
        .sortedWith(compareBy({ it[0] }, { it[1] }))
        .forEach { bw.write("${it[0]} ${it[1]}\n") }
    bw.flush()
}