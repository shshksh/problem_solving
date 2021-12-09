package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val string = br.readLine()
    val target = br.readLine()

    val q = ArrayDeque<Char>()

    outer@ for (c in string) {
        q.addLast(c)

        var check = false
        if (q.size >= target.length) {
            for (i in 1..target.length) {
                if (q[q.size - i] != target[target.length - i])
                    continue@outer
            }
            check = true
        }

        if (check) {
            for (i in 1..target.length) {
                q.removeLast()
            }
        }
    }
    if (q.isEmpty())
        bw.write("FRULA")
    else {
        for (c in q) {
            bw.write(c.code)
        }
    }
    bw.flush()
}
