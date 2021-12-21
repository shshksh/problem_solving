package nonlinear.graph

fun permute(nums: IntArray): List<List<Int>> {
    val exclude = mutableListOf<Int>()
    val result = mutableListOf<List<Int>>()

    fun permuteOf(include: MutableList<Int>, exclude: MutableList<Int>) {
        if (include.isEmpty()) {
            result.add(exclude)
        }
        for (e in include) {
            permuteOf((include - e) as MutableList<Int>, (exclude + e) as MutableList<Int>)
        }
    }

    permuteOf(nums.toMutableList(), exclude)

    return result
}

fun main() {
    println(permute(intArrayOf(1, 2, 3)))
}
