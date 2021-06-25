package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    var set = mutableSetOf<String>()
    repeat(n) {
        val command = br.readLine().split(" ")
        when (command[0]) {
            "add" -> set.add(command[1])
            "remove" -> set.remove(command[1])
            "check" -> if (command[1] in set) bw.write("1\n") else bw.write("0\n")
            "toggle" -> if (command[1] in set) set.remove(command[1]) else set.add(command[1])
            "all" -> set = (1..20).map { it.toString() }.toMutableSet()
            "empty" -> set.clear()
        }
    }
    bw.flush()
}