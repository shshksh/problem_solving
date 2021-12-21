fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    val adjArr = Array(n + 1) { BooleanArray(n + 1) }
    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adjArr[a][b] = true
        adjArr[b][a] = true
    }
    val visit = BooleanArray(n + 1)
    fun dfs(row: Int) {
        bw.write("$row ")
        visit[row] = true
        for ((i, vertex) in adjArr[row].withIndex()) {
            if (vertex && !visit[i]) {
                dfs(i)
            }
        }
    }
    dfs(v)
    bw.newLine()
    for (i in visit.indices) visit[i] = false
    val q = ArrayDeque<Int>()
    q.addLast(v)
    visit[v] = true
    while (q.isNotEmpty()) {
        val vertex = q.removeFirst()
        bw.write("$vertex ")
        for ((i, vv) in adjArr[vertex].withIndex()) {
            if (vv && !visit[i]) {
                visit[i] = true
                q.addLast(i)
            }
        }
    }
    bw.flush()
}
