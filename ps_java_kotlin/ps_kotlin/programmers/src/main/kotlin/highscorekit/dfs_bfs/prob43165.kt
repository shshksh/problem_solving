package highscorekit.dfs_bfs

var count = 0

fun solution(numbers: IntArray, target: Int): Int {
    fun dfs(slice: IntArray, sum: Int) {
        if (slice.isEmpty()) {
            if (sum == target)
                count++
            return
        }

        dfs(slice.sliceArray(1 until slice.size), sum + slice[0])
        dfs(slice.sliceArray(1 until slice.size), sum - slice[0])
    }
    dfs(numbers, 0)

    return count
}

fun main() {
    println(solution(intArrayOf(1, 1, 1, 1, 1), 3))
}
