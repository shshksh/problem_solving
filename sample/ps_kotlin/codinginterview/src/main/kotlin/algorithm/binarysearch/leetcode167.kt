package algorithm.binarysearch

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var i = 0
    var j = numbers.size - 1

    while (i < j) {
        when {
            numbers[i] + numbers[j] < target -> i++
            numbers[i] + numbers[j] > target -> j--
            else -> return intArrayOf(i, j)
        }
    }
    return intArrayOf()
}
