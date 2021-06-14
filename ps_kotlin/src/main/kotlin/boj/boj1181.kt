package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    br.readLine()
    br.readLines().distinct().sortedWith { o1, o2 ->
        if (o1.length != o2.length) o1.length - o2.length else o1.compareTo(o2)
    }.forEach {
        bw.write("$it\n")
    }
    bw.flush()
}