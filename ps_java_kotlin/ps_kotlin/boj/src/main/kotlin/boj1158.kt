import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var cursor = 0
    var curr = 1

    val list = ArrayDeque<Int>()
    for (i in 1..n)
        list.addLast(i)
    var iter = list.listIterator()

    val sb = StringJoiner(", ", "<", ">")

    while (list.isNotEmpty()) {
        if (cursor == k) {
            iter.remove()
            sb.add("$curr")
            cursor = 0
        }
        if (!iter.hasNext())
            iter = list.listIterator()
        if (iter.hasNext()) {
            curr = iter.next()
            cursor++
        }
    }

    println(sb)
}

// 1 2 3 4 5 6 7 8 9
// 9, 9 - 9 1 3 6 4 5 2 7 8
