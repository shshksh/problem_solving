package boj

private val bw = System.out.bufferedWriter()

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted().distinct()

    dfs(arr, 0, m, "")
    bw.flush()
}

fun dfs(arr: List<Int>, start: Int, m: Int, s: String) {
    if (m == 0) {
        bw.write(s.slice(1..s.lastIndex) + "\n")
        return
    }
    for (i in start until arr.size) {
        dfs(arr, i, m - 1, "$s ${arr[i]}")
    }
}

