package nonlinear.graph

fun subsets(nums: IntArray): List<List<Int>> {
    val length = 1.shl(nums.size)
    val result = mutableListOf<List<Int>>()

    for (i in 0 until length) {
        var (foo, j) = Pair(i, 0)
        val subset = mutableListOf<Int>()
        while (foo > 0) {
            if (foo.and(1) > 0)
                subset.add(nums[j])
            foo = foo.shr(1)
            j++
        }
        result.add(subset)
    }

    return result
}

fun main() {
    println(subsets(intArrayOf(1, 2, 3)))
}
