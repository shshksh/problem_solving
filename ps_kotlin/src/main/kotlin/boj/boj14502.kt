package boj

/*
Source: 백준 14502 연구소(https://www.acmicpc.net/problem/14502)
Solved: O
Approach: 완전 탐색 + BFS
Review:
- 맵의 크기가 최대 8x8이기 때문에 완전 탐색으로 최대값을 찾을 수 있을거라 생각함.
맵의 너비만큼 3중 반복문을 돌며 모두 빈칸일 때 벽으로 만들고 바이러스 전파 시작.
바이러스의 전파는 초기 지역 리스트를 받은 후 큐에 넣어서 BFS로 전파.
전파가 끝나면 맵에 남아있는 0의 수를 카운트하여 리턴.
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val (height, width) = br.readLine().split(" ").map { it.toInt() }

    println(boj14502(height, width))
}

private fun boj14502(height: Int, width: Int): Int {
    val map = Array(height) { IntArray(width) }
    val virusList = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until height) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 0 until width) {
            val element = st.nextToken().toInt()
            if (element == 2)
                virusList.add(i to j)
            map[i][j] = element
        }
    }

    val size = height * width
    var maxSafeArea = 0

    for (i in 0 until size - 2) {
        if (map[i / width][i % width] != 0)
            continue
        for (j in i + 1 until size - 1) {
            if (map[j / width][j % width] != 0)
                continue
            for (k in j + 1 until size) {
                if (map[k / width][k % width] != 0)
                    continue
                maxSafeArea =
                    maxOf(maxSafeArea,
                        calcSafeArea(copyMap(map, width, i, j, k), virusList))
            }
        }
    }
    return maxSafeArea
}

private fun calcSafeArea(
    map: Array<IntArray>,
    virusList: MutableList<Pair<Int, Int>>,
): Int {
    val q = ArrayDeque<Pair<Int, Int>>()
    for (pair in virusList) {
        q.offer(pair)
    }

    while (q.isNotEmpty()) {
        val pos = q.poll()
        for (i in 0 until 4) {
            val x = pos.first + dx[i]
            val y = pos.second + dy[i]
            if (isValid(x, y, map)) {
                map[x][y] = 2
                q.offer(x to y)
            }
        }
    }

    var sum = 0
    for (row in map) {
        sum += row.count { it == 0 }
    }
    return sum
}

private fun copyMap(
    map: Array<IntArray>, width: Int, i: Int, j: Int, k: Int,
): Array<IntArray> =
    map.map { it.copyOf() }.toTypedArray().apply {
        get(i / width)[i % width] = 1
        get(j / width)[j % width] = 1
        get(k / width)[k % width] = 1
    }

private fun isValid(x: Int, y: Int, map: Array<IntArray>): Boolean {
    if (x < 0 || y < 0 || x >= map.size || y >= map[0].size || map[x][y] != 0)
        return false
    return true
}
