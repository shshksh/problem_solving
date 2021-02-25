package codinginterview.algorithm.binarysearch

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    for (row in matrix) {
        if (row.binarySearch(target) >= 0)
            return true
    }
    return false
}