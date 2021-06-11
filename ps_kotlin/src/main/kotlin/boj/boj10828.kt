package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st = Stack<String>()

    val n = br.readLine().toInt()
    repeat(n) {
        val command = br.readLine()
        when {
            command.startsWith("push") -> {
                val value = command.split(" ")[1]
                st.push(value)
            }
            command == "top" -> {
                if (st.isEmpty()) bw.write("-1\n") else bw.write("${st.peek()}\n")
            }
            command == "size" -> {
                bw.write("${st.size}\n")
            }
            command == "empty" -> {
                if (st.isEmpty()) bw.write("1\n") else bw.write("0\n")
            }
            command == "pop" -> {
                if (st.isEmpty()) bw.write("-1\n") else bw.write("${st.pop()}\n")
            }
        }
    }
    bw.flush()
}