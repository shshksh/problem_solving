package algorithm.dp

fun maxSubArray(nums: IntArray): Int {
    var result = nums[0]
    var currMax = nums[0]
    for (i in 1 until nums.size) {
        currMax = maxOf(currMax + nums[i], nums[i])
        result = maxOf(result, currMax)
    }
    return result
}

fun main() {
    println(maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
    println(maxSubArray(intArrayOf(-1, 5, 4, -1, 7, 8)))
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray(intArrayOf(0, -1, -2, -3, -4, -5)))
    println(maxSubArray(intArrayOf(0, 1, 2, 3, 4, 5)))
    println(maxSubArray(intArrayOf(0, -1, 2, -3, 4, -5, 6)))
    println(maxSubArray(intArrayOf(5, 5, 5, 5, 5, -2, -2, -2, 5, 5, 5)))
}
