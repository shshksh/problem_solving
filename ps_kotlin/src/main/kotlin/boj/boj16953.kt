package boj

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }
    var count = 0
    if (a == b) {
        println(1)
        return
    }
    val q = ArrayDeque<Long>()
    q.add(a)
    while (q.isNotEmpty()) {
        val size = q.size
        count++

        for (i in 1..size) {
            val num = q.removeFirst()
            if(num == b) {
                println(count)
                return
            }

            if (num * 2 <= b)
                q.addLast(num * 2)
            if (num * 10 + 1 <= b)
                q.addLast(num * 10 + 1)
        }
    }
    println(-1)
}