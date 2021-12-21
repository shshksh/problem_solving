fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
    val b = readLine()!!.split(" ").map { it.toInt() }.sorted()

    println(a.zip(b) { i1, i2 -> i1 * i2 }.reduce { acc, i -> acc + i })
}
