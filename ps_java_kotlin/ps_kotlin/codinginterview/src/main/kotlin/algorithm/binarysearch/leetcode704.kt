package algorithm.binarysearch

fun search(nums: IntArray, target: Int): Int {
    fun binarySearch(nums: IntArray, from: Int, to: Int): Int {
        if (from > to)
            return -1
        val mid = (from + to) / 2
        return when {
            nums[mid] == target -> mid
            nums[mid] < target -> binarySearch(nums, mid + 1, to)
            else -> binarySearch(nums, from, mid - 1)
        }
    }
    return binarySearch(nums, 0, nums.size - 1)
}

fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), -2))
}
