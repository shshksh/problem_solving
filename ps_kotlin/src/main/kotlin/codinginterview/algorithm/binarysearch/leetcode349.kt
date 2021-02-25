package codinginterview.algorithm.binarysearch

//fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
//    return nums1.filter { nums2.contains(it) }
//        .distinct()
//        .toIntArray()
//}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toMutableSet()

    val result = mutableSetOf<Int>()

    for (i in nums2) {
        if (set1.contains(i)) {
            result.add(i)
        }
    }

    return result.toIntArray()
}