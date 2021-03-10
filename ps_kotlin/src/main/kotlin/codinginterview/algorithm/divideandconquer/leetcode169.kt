package codinginterview.algorithm.divideandconquer

fun majorityElement(nums: IntArray): Int {
    var counter = 0
    var result = 0
    nums.groupBy { it }
        .forEach { (t, u) ->
            if (u.size > counter) {
                counter = u.size
                result = t
            }
        }
    return result
}