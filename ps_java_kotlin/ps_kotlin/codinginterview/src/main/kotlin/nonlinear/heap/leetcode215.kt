package nonlinear.heap

fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.sortDescending()
    return nums[k - 1]
}
