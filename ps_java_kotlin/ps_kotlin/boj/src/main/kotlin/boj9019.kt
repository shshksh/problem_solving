fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    for (i in 1..t) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val set = mutableSetOf<Int>()
        val q = ArrayDeque<Pair<String, Int>>()
        q.addLast("" to a)

        while (q.isNotEmpty()) {
            val value = q.removeFirst()

            if (value.second == b) {
                bw.write(value.first + "\n")
                break
            }

            (value.second * 2 % 10000).let {
                if (it !in set) {
                    set.add(it)
                    q.addLast(value.first + "D" to it)
                }
            }
            (if (value.second - 1 < 0) 9999 else value.second - 1).let {
                if (it !in set) {
                    set.add(it)
                    q.addLast(value.first + "S" to it)
                }
            }
            val msb = value.second / 1000
            (value.second * 10 % 10000 + msb).let {
                if (it !in set) {
                    set.add(it)
                    q.addLast(value.first + "L" to it)
                }
            }
            val lsb = value.second % 10
            (value.second / 10 + lsb * 1000).let {
                if (it !in set) {
                    set.add(it)
                    q.addLast(value.first + "R" to it)
                }
            }
        }
    }
    bw.flush()
}
