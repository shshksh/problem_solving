package boj

private val bw = System.out.bufferedWriter()

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val visit = mutableMapOf<Int, Int>()
    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()
    for (i in arr) {
        visit[i] = visit.getOrDefault(i, 0) + 1
    }

    dfs(visit, arr, m, "")
    bw.flush()
}

private fun dfs(visit: MutableMap<Int, Int>, arr: List<Int>, m: Int, acc: String) {
    if (m == 0) {
        bw.write("${acc.slice(1..acc.lastIndex)}\n")
        return
    }
    for (i in arr.indices) {
        if (i > 0 && arr[i] == arr[i - 1] || visit[arr[i]] == 0)
            continue
        visit[arr[i]] = visit[arr[i]]!! - 1
        dfs(visit, arr, m - 1, "$acc ${arr[i]}")
        visit[arr[i]] = visit[arr[i]]!! + 1
    }
}
