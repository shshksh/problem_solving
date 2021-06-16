package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    while(true) {
        val number = br.readLine()

        if (number == "0")
            break

        if (number == number.reversed())
            bw.write("yes\n")
        else
            bw.write("no\n")
    }
    bw.flush()
}