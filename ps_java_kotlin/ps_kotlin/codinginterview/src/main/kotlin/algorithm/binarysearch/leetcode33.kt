package algorithm.binarysearch

class LeetCode33 {
    fun searchBorder(nums: IntArray, start: Int, end: Int): Int {
        if (start == end)
            return start + 1
        val mid = (start + end) / 2
        return if (nums[mid] <= nums[start])
            searchBorder(nums, start, mid)
        else
            searchBorder(nums, mid, end)
    }

    fun search(nums: IntArray, target: Int): Int {
        val border = searchBorder(nums, 0, nums.size - 1)

        var index = nums.binarySearch(target, 0, border)
        if (index < 0)
            index = nums.binarySearch(target, border, nums.size)
        return if (index < 0)
            -1
        else
            index
    }
}

fun main() {
    val c = LeetCode33()

    println(c.searchBorder(intArrayOf(1, 2, 3, 4, 5, 6, 7), 0, 6))
    println(c.searchBorder(intArrayOf(2, 3, 4, 5, 6, 7, 1), 0, 6))
    println(c.searchBorder(intArrayOf(3, 4, 5, 6, 7, 1, 2), 0, 6))
    println(c.searchBorder(intArrayOf(4, 5, 6, 7, 1, 2, 3), 0, 6))
    println(c.searchBorder(intArrayOf(5, 6, 7, 1, 2, 3, 4), 0, 6))
    println(c.searchBorder(intArrayOf(6, 7, 1, 2, 3, 4, 5), 0, 6))
    println(c.searchBorder(intArrayOf(7, 1, 2, 3, 4, 5, 6), 0, 6))
    println()

    println(c.search(intArrayOf(1, 2, 3, 4, 5, 6, 7), 7))
}
