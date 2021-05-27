package boj

/*
Source: 백준 1600 말이 되고픈 원숭이(https://www.acmicpc.net/problem/1600)
Solved: X (메모리 초과, 시간 초과)
Approach: BFS. 필드를 초기화 하고 방문할 때 K값 잔여 횟수를 음수로 최신화하며 탐색. 동일한 위치를
방문하더라도 K값의 잔여 횟수가 더 많다면 방문할 수 있도록 구현.
Review:
- 내 풀이: test11에서 2초 이상 소요되고 목적지에 도착했을 때 큐에 들어있는 Step 객체가 400만개를 초과함.
- 솔루션: https://data-make.tistory.com/480 참고. visited 배열을 3차원 배열로 하여 k값이 동일한
접근을 제거.
 */

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

    val visited = Array(height) { Array(width) { BooleanArray(k + 1) } }
    visited[0][0][0] = true

    while (q.isNotEmpty()) {
        val curr = q.poll()

        if (curr.x == height - 1 && curr.y == width - 1)
            return curr.step

        if (curr.k > 0) {
            addHorseStep(curr, q, field, visited)
        }
        addMonkeyStep(curr, q, field, visited)
    }
    return -1
}

fun addMonkeyStep(
    curr: Step,
    q: LinkedList<Step>,
    field: Array<IntArray>,
    visited: Array<Array<BooleanArray>>,
) {
    for (i in 0 until 4) {
        val x = curr.x + dxm[i]
        val y = curr.y + dym[i]
        if (isValid(x, y, field) && !visited[x][y][curr.k]) {
            q.offer(Step(x, y, curr.k, curr.step + 1))
            visited[x][y][curr.k] = true
        }
    }
}

fun addHorseStep(
    curr: Step,
    q: LinkedList<Step>,
    field: Array<IntArray>,
    visited: Array<Array<BooleanArray>>,
) {
    for (i in 0 until 8) {
        val x = curr.x + dxh[i]
        val y = curr.y + dyh[i]
        if (isValid(x, y, field) && !visited[x][y][curr.k - 1]) {
            q.offer(Step(x, y, curr.k - 1, curr.step + 1))
            visited[x][y][curr.k - 1] = true
        }
    }
}

fun isValid(x: Int, y: Int, field: Array<IntArray>): Boolean {
    if (x < 0 || x >= field.size || y < 0 || y >= field[0].size || field[x][y] == 1)
        return false
    return true
}