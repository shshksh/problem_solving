package codinginterview.algorithm.bitwise

fun singleNumber(nums: IntArray) = nums.reduce { acc, i -> acc xor i }
