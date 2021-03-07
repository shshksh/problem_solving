package codinginterview.algorithm.greedy

import java.util.*

//fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
//    val result = mutableListOf<IntArray>()
//    val sortedList = people.sortedWith(Comparator { o1, o2 ->
//        if (o1[0] == o2[0])
//            o1[1] - o2[1]
//        else
//            o1[0] - o2[0]
//    }).toMutableList()
//
//    while (result.size < people.size) {
//        for (ints in sortedList) {
//            if (ints[1] == 0) {
//                result.add(ints)
//                sortedList.remove(ints)
//                break
//            } else {
//                if (result.count { it[0] >= ints[0] } == ints[1]) {
//                    result.add(ints)
//                    sortedList.remove(ints)
//                    break
//                }
//            }
//        }
//    }
//
//    return result.toTypedArray()
//}

// solution
fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    val q = PriorityQueue<IntArray>(kotlin.Comparator { o1, o2 ->
        if (o1[0] == o2[0])
            o1[1] - o2[1]
        else
            o2[0] - o1[0]
    })
    for (person in people) {
        q.add(person)
    }

    val result = mutableListOf<IntArray>()
    while (q.isNotEmpty()) {
        val person = q.poll()
        result.add(person[1], person)
    }
    return result.toTypedArray()
}
