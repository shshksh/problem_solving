package algorithm.greedy

//fun findContentChildren(g: IntArray, s: IntArray): Int {
//    var result = 0
//    val greedQ = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o1 - o2 })
//    val cookieQ = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o1 - o2 })
//
//    for (i in g)
//        greedQ.add(i)
//    for (i in s)
//        cookieQ.add(i)
//
//    while (greedQ.isNotEmpty() && cookieQ.isNotEmpty()) {
//        if (cookieQ.peek() >= greedQ.peek()) {
//            result++
//            greedQ.poll()
//            cookieQ.poll()
//        } else {
//            cookieQ.poll()
//        }
//    }
//
//    return result
//}

fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    var (i, j) = 0 to 0
    var result = 0
    while (i < g.size && j < s.size) {
        if (g[i] > s[j]) {
            j++
        } else {
            result++
            i++
            j++
        }
    }
    return result
}

fun main() {
    println(findContentChildren(intArrayOf(10, 9, 8, 7), intArrayOf(5, 6, 7, 8)))
}
