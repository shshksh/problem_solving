package codinginterview.nonlinear.heap

import java.util.*

fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.sortDescending()
    return nums[k - 1]
}