package codinginterview.algorithm.sort

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith(Comparator { o1, o2 ->
        if (o1[0] == o2[0])
            o1[1] - o2[1]
        else
            o1[0] - o2[0]
    })
    val result = mutableListOf<IntArray>()
    result += intervals[0]

    intervals.forEach { ints ->
        if (result.last()[1] >= ints[0] && result.last()[1] < ints[1]) {
            result.last()[1] = ints[1]
        } else if (result.last()[1] < ints[0]) {
            result += ints
        }
    }

    return result.toTypedArray()
}

fun main() {
    merge(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
    ).forEach { println(it.contentToString()) }
}