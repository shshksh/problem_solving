package algorithm.sort

fun largestNumber(nums: IntArray): String {
    if (nums.all { it == 0 })
        return "0"
    return nums.map(Int::toString)
        .sortedWith { o1, o2 -> (o2 + o1).compareTo(o1 + o2) }
        .joinToString("")
}

fun main() {
    println(largestNumber(intArrayOf(34323, 3432)))
}
