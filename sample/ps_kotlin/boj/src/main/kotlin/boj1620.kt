fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Int>()
    val arr = Array(n + 1) { "" }
    repeat(n) {
        val name = br.readLine()
        arr[it + 1] = name
        map[name] = it + 1
    }
    repeat(m) {
        val input = br.readLine()
        input.toIntOrNull()?.let {
            bw.write("${arr[it]}\n")
        } ?: run {
            bw.write("${map[input]}\n")
        }
    }
    bw.flush()
}
