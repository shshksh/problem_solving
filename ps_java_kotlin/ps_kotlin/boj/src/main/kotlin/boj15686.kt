/*
Source: 백준 15686 치킨배달(https://www.acmicpc.net/problem/15686)
Solved:
Approach: 완전 탐색
Review:
- M <= 13 에서 13 C M의 최대값은 1716, N^2 <= 2500. 따라서 완전 탐색이면 4290000 안에 해결할 수 있
지 않을까.
1. 맵을 파싱.
2. 치킨집 중 m개를 선택하는 모든 경우의 수 탐색.
3. 각각의 경우의 수 마다 남은 치킨집을 초기값으로 BFS 수행하여 최소값 산출.
 */

import java.util.*

fun main() {
    val (size, m) = readLine()!!.split(" ").map { it.toInt() }

    val map = Array(size) { IntArray(size) }
    val storeList = mutableListOf<IntArray>()
    for (i in 0 until size) {
        val st = StringTokenizer(readLine()!!, " ")
        for (j in 0 until size) {
            st.nextToken().toInt().let {
                if (it == 2)
                    storeList.add(intArrayOf(i, j))
                map[i][j] = it
            }
        }
    }

    println(boj15686(m, map, storeList))
}

fun boj15686(m: Int, map: Array<IntArray>, storeList: List<IntArray>): Int {
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    // storeList.size Comb m
    var result = Int.MAX_VALUE
    fun calcMinDistance(select: List<Int>): Int {
        val q = ArrayDeque<IntArray>()
        val distance = Array(map.size) { IntArray(map.size) { -1 } }
        var minDistance = 0

        select.forEach {
            q.offer(storeList[it])
            distance[storeList[it][0]][storeList[it][1]] = 0
        }

        while (q.isNotEmpty()) {
            val pos = q.poll()

            for (i in 0..3) {
                val x = pos[0] + dx[i]
                val y = pos[1] + dy[i]
                if (isValid(map, x, y) && distance[x][y] < 0) {
                    distance[x][y] = distance[pos[0]][pos[1]] + 1
                    if (map[x][y] == 1)
                        minDistance += distance[x][y]
                    q.offer(intArrayOf(x, y))
                }
            }
        }
        return minDistance
    }

    fun dfs(select: List<Int>) {
        if (select.size == m) {
            result = minOf(result, calcMinDistance(select))
        }
        val last = select.lastOrNull() ?: -1
        if (last == storeList.lastIndex)
            return
        for (i in last + 1..storeList.lastIndex) {
            dfs(select + i)
        }
    }
    dfs(emptyList())

    return result
}

private fun isValid(map: Array<IntArray>, x: Int, y: Int): Boolean {
    if (x < 0 || y < 0 || x >= map.size || y >= map[0].size)
        return false
    return true
}
