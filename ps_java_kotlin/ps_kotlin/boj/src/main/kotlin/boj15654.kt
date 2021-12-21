private val bw = System.out.bufferedWriter()

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val visit = BooleanArray(n)

    for (i in arr.indices) {
        visit[i] = true
        dfs(visit, arr, n, m - 1, "${arr[i]}")
        visit[i] = false
    }
    bw.flush()
}

private fun dfs(visit: BooleanArray, arr: List<Int>, n: Int, m: Int, acc: String) {
    if (m == 0) {
        bw.write("$acc\n")
        return
    }
    for (i in 0 until n) {
        if (!visit[i]) {
            visit[i] = true
            dfs(visit, arr, n, m - 1, "$acc ${arr[i]}")
            visit[i] = false
        }
    }
}
