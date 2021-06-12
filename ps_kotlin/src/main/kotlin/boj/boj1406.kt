package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val list = LinkedList<Char>()
    for (c in br.readLine()) {
        list.add(c)
    }
    val iterator = list.listIterator(list.size)
    val n = br.readLine().toInt()

    repeat(n) {
        val command = br.readLine().split(" ")
        when (command[0]) {
            "L" -> if (iterator.hasPrevious()) iterator.previous()
            "D" -> if (iterator.hasNext()) iterator.next()
            "B" -> if (iterator.hasPrevious()) {
                iterator.previous()
                iterator.remove()
            }
            "P" -> iterator.add(command[1][0])
        }
    }
    bw.write(list.toCharArray())
    bw.flush()
}