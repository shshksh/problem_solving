package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        map[br.readLine()] = 1
    }
    repeat(m) {
        val name = br.readLine()
        map[name] = (map[name] ?: 0) + 1
    }
    val result = map.filter { (_, v) -> v > 1 }.keys.sorted()
    bw.write("${result.size}\n")
    for (s in result) {
        bw.write("$s\n")
    }
    bw.flush()
}