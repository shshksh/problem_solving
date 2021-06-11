package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val q = ArrayDeque<String>()

    val n = br.readLine().toInt()
    repeat(n) {
        val command = br.readLine()
        when {
            command.startsWith("push") -> {
                val value = command.split(" ")[1]
                q.addLast(value)
            }
            command == "front" -> {
                if (q.isEmpty()) bw.write("-1\n") else bw.write("${q.first()}\n")
            }
            command == "back" -> {
                if (q.isEmpty()) bw.write("-1\n") else bw.write("${q.last()}\n")
            }
            command == "size" -> {
                bw.write("${q.size}\n")
            }
            command == "empty" -> {
                if (q.isEmpty()) bw.write("1\n") else bw.write("0\n")
            }
            command == "pop" -> {
                if (q.isEmpty()) bw.write("-1\n") else bw.write("${q.removeFirst()}\n")
            }
        }
    }
    bw.flush()
}
