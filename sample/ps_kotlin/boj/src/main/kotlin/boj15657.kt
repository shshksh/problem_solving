private val bw = System.out.bufferedWriter()

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()

    for (i in arr.indices) {
        dfs(arr, i, n, m - 1, "${arr[i]}")
    }
    bw.flush()
}

private fun dfs(arr: List<Int>, start: Int, n: Int, m: Int, acc: String) {
    if (m == 0) {
        bw.write("$acc\n")
        return
    }
    for (i in start until n) {
        dfs(arr, i, n, m - 1, "$acc ${arr[i]}")
    }
}
