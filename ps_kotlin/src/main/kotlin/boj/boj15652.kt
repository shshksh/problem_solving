package boj

private val bw = System.out.bufferedWriter()

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    for (i in 1..n)
        dfs(i, n, m - 1, "$i")
    bw.flush()
}

private fun dfs(start: Int, n: Int, m: Int, acc: String) {
    if (m == 0) {
        bw.write("$acc\n")
        return
    }
    for (i in start..n) {
        dfs(i, n, m - 1, "$acc $i")
    }
}