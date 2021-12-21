package algorithm.sort

fun sortColors(nums: IntArray): Unit {
    val count = IntArray(3)
    for (num in nums) {
        count[num]++
    }
    var k = 0
    for ((i, v) in count.withIndex()) {
        for (j in 0 until v) {
            nums[k++] = i
        }
    }
}
