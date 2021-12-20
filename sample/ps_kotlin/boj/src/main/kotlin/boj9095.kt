fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    var result = 0

    fun dfs(n: Int, acc: Int) {
        if (acc == n)
            result++
        if (acc > n)
            return
        dfs(n, acc + 1)
        dfs(n, acc + 2)
        dfs(n, acc + 3)
    }

    repeat(t) {
        result = 0
        dfs(br.readLine().toInt(), 0)
        bw.write("$result\n")
    }
    bw.flush()
}
