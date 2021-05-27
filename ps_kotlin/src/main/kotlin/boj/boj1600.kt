package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dxm = arrayOf(-1, 0, 1, 0)
val dym = arrayOf(0, 1, 0, -1)
val dxh = arrayOf(-2, -2, -1, 1, 2, 2, 1, -1)
val dyh = arrayOf(-1, 1, 2, 2, 1, -1, -2, -2)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    val (width, height) = br.readLine().split(" ").map { it.toInt() }
    val field = Array(height) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    br.close()

    println(boj1600(k, width, height, field))
}

class Step(val x: Int, val y: Int, val k: Int, val step: Int)

fun boj1600(k: Int, width: Int, height: Int, field: Array<IntArray>): Int {

    val q = LinkedList<Step>()
    q.offer(Step(0, 0, k, 0))
    field[0][0] = -k - 1

    while (q.isNotEmpty()) {
        val curr = q.poll()
        if (-curr.k-1 > field[curr.x][curr.y])
            continue

        if (curr.x == height - 1 && curr.y == width - 1)
            return curr.step

        if (curr.k > 0) {
            addHorseStep(curr, q, field)
        }
        addMonkeyStep(curr, q, field)
    }
    return -1
}

fun addMonkeyStep(curr: Step, q: LinkedList<Step>, field: Array<IntArray>) {
    for (i in 0 until 4) {
        val x = curr.x + dxm[i]
        val y = curr.y + dym[i]
        if (isValid(x, y, field) && field[x][y] > -curr.k - 1) {
            q.offer(Step(x, y, curr.k, curr.step + 1))
            field[x][y] = -curr.k - 1
        }
    }
}

fun addHorseStep(curr: Step, q: LinkedList<Step>, field: Array<IntArray>) {
    for (i in 0 until 8) {
        val x = curr.x + dxh[i]
        val y = curr.y + dyh[i]
        if (isValid(x, y, field) && field[x][y] > -curr.k - 1) {
            q.offer(Step(x, y, curr.k - 1, curr.step + 1))
            field[x][y] = -curr.k
        }
    }
}

fun isValid(x: Int, y: Int, field: Array<IntArray>): Boolean {
    if (x < 0 || x >= field.size || y < 0 || y >= field[0].size || field[x][y] == 1)
        return false
    return true
}