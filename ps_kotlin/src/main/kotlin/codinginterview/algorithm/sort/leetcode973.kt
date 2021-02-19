package codinginterview.algorithm.sort

fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
    fun pow(point: IntArray) = point[0] * point[0] + point[1] * point[1]
    points.sortWith { o1: IntArray, o2: IntArray -> pow(o1) - pow(o2) }
    return points.sliceArray(0 until K)
}