package codinginterview.algorithm.dp

fun rob(nums: IntArray): Int {
    val acc: Array<Pair<Int, Int>> = Array(nums.size + 1) { 0 to 0 }

    for ((i, v) in nums.withIndex()) {
        acc[i + 1] = maxOf(acc[i].first, acc[i].second) to acc[i].first + v
    }

    return maxOf(acc[nums.size].first, acc[nums.size].second)
}