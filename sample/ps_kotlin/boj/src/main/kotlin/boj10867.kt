fun main() {
    readLine()!!
    println(readLine()!!.split(" ").map { it.toInt() }.toSortedSet().joinToString(" "))
}
