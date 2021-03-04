package codinginterview.algorithm.slidingwindow

import java.util.*

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val q = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o2.second - o1.second }
    var start = k - 1
    for (i in 0 until start) {
        q.add(i to nums[i])
    }

    val arr = mutableListOf<Int>()

    while (start < nums.size) {
        q.add(start to nums[start])

        while (q.peek().first + k <= start)
            q.poll()

        arr.add(q.peek().second)

        start++
    }

    return arr.toIntArray()
}