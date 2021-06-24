package boj

import kotlin.math.pow

fun main() {
    val (n, r, c) = readLine()!!.split(" ").map { it.toInt() }
    val size = 2.0.pow(n.toDouble()).toInt()

    fun dfs(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        if (x1 == x2 - 1 && y1 == y2 - 1) {
            return 0
        }
        val diff = (x2 - x1) / 2
        return if (x1 + diff <= r && y1 + diff <= c) {
            diff * diff * 3 + dfs(x1 + diff, y1 + diff, x2, y2)
        } else if (x1 + diff <= r && y1 <= c) {
            diff * diff * 2 + dfs(x1 + diff, y1, x2, y1 + diff)
        } else if (x1 <= r && y1 + diff <= c) {
            diff * diff + dfs(x1, y1 + diff, x1 + diff, y2)
        } else {
            dfs(x1, y1, x1 + diff, y1 + diff)
        }
    }

    println(dfs(0, 0, size, size))
}