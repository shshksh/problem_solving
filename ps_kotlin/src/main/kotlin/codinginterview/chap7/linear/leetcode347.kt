package codinginterview.chap7.linear

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    return nums.groupBy { it }
        .values
        .sortedBy { it.size }
        .takeLast(k)
        .map { list -> list[0] }
        .toIntArray()
}

fun main() {
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3, 0, 0, 0, 5, 5, 5, 5), k = 2).joinToString())
}