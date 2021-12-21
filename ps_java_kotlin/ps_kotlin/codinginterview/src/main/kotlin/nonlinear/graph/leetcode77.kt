package nonlinear.graph

fun combine(n: Int, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val exclude = mutableListOf<Int>()

    fun dfs(include: MutableList<Int>, exclude: MutableList<Int>) {
        if (include.size + exclude.size < k)
            return
        if (exclude.size == k) {
            result += exclude
        }
        for ((i, _) in include.withIndex()) {
            dfs(include.subList(i + 1, include.size), (exclude + include[i]) as MutableList<Int>)
        }
    }

    dfs((1 until n + 1).toMutableList(), exclude)

    return result
}

fun main() {
    println(combine(4, 2))
}
