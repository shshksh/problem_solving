package nonlinear.graph

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val exclude = mutableListOf<Int>()

    fun dfs(include: MutableList<Int>, exclude: MutableList<Int>) {
        if (exclude.sum() == target) {
            result += exclude
        } else if (exclude.sum() > target) {
            return
        }
        for ((i, _) in include.withIndex()) {
            dfs(include.subList(i, include.size), (exclude + include[i]) as MutableList<Int>)
        }
    }

    dfs(candidates.toMutableList(), exclude)

    return result
}

fun main() {
    println(combinationSum(intArrayOf(2, 3, 6, 7), 7))
}
