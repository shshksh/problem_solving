fun main() {
    val (n, s) = readLine()!!.split(" ").map { it.toInt() }
    val sequence = readLine()!!.split(" ").map { it.toInt() }
    var result = 0

    fun dfs(start: Int, acc: Int) {
        if (start > sequence.lastIndex) {
            if (acc == s) result++
            return
        }

        dfs(start + 1, acc + sequence[start])
        dfs(start + 1, acc)
    }

    for (i in sequence.indices) {
        dfs(i + 1, sequence[i])
    }
    println(result)
}
