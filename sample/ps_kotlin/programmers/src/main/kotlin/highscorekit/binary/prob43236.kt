package highscorekit.binary

//fun boj.solution(distance: Int, rocks: IntArray, n: Int): Int {
//    rocks.sort()
//
//    val diff = IntArray(rocks.size + 1)
//    diff[0] = rocks.first()
//    for (i in 0 until rocks.size - 1)
//        diff[i + 1] = rocks[i + 1] - rocks[i]
//    diff[diff.size - 1] = distance - rocks.last()
//
//    for (i in 1..n) {
//        val index = diff.indexOf(diff.filter { it >= 0 }.minOrNull() ?: -1)
//
//        if (index == 0 || index == diff.lastIndex)
//            diff[index] = -1
//        else {
//            if (diff[index] + diff[index - 1] > diff[index] + diff[index + 1]) {
//                diff[index + 1] += diff[index]
//                diff[index] = -1
//            } else {
//                diff[index - 1] += diff[index]
//                diff[index] = -1
//            }
//        }
//    }
//
//    println(diff.contentToString())
//
//    return diff.filter { it >= 0 }.minOrNull() ?: -1
//}
//
//fun main() {
//    println(boj.solution(25, intArrayOf(2, 14, 11, 21, 17), 2))
//    println(boj.solution(30, intArrayOf(2, 14, 11, 25, 17), 2))
//    println(boj.solution(1000000000, intArrayOf(2, 14, 11, 25, 17), 1))
//    println(boj.solution(16, intArrayOf(4, 8, 11), 2))
//}
// 실패
