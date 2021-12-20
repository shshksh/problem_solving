fun main() {
    println(readLine()!!
        .split(" ")
        .map { it.toInt() * it.toInt() }
        .reduce { acc, i -> acc + i } % 10)
}
