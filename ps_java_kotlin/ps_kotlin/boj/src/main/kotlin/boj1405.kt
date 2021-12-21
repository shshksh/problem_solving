/*
Source: 백준 1405 미친 로봇(https://www.acmicpc.net/problem/1405)
Solved: ❓(3번째 풀이에서 시간 초과)
Approach: n 번동안 각 방향으로 이동하는 브루트 포스(DFS). 이미 방문했던 곳을 재방문하면 바로 확률을 리턴
하여 탐색 횟수를 줄임(백 트래킹).
Review:
- 첫 번째 접근: 메모리 초과 및 오답. 통과된 답을 메모이제이션하는 map과 재귀함수 내에서 set, pair로 상태
를 저장하는 것이 원인이 된 듯 하다. 또한 방향 offset을 잘못 설정함.
- 두 번째 접근: 통과 되었지만 메모리 사용량과 퍼포먼스가 좋지 못함. Pair를 쓰는게 원인인듯?
- 세 번째 접근: 시간 초과가 나오는데 이유를 모르겠음. 두 번째 접근보다 최적화 한것 같은데... 다시 보니
원인은 확률을 계산하는 함수에 있는 듯 하다. 솔루션 처럼 점진적으로 확률을 곱하면 이전의 결과가 저장되지만
내가 한 방식과 같이 pow 함수를 사용하면 탈출 조건을 만날 때 마다 중복되는 pow 연산이 발생한다.
- 솔루션: https://www.acmicpc.net/source/20019897를 참고. 탈출 조건에 도달했을 때 확률을 계산하지
않고 dfs 결과에 점진적으로 해당 확률을 곱하며 연산.
 */

import kotlin.system.measureTimeMillis

fun main() {
    val input = readLine()!!
    println(measureTimeMillis {
        boj1405(input)
    })
}

// 솔루션
fun boj1405(input: String) {
    val param = input.split(" ")
    val n = param[0].toInt()
    val probability = param.subList(1, param.size).map { it.toDouble() / 100 }
    val offset =
        arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    val map = Array(29) { BooleanArray(29) }

    fun dfs(n: Int, x: Int, y: Int): Double {
        if (map[x][y])
            return 1.0
        if (n == 0)
            return 0.0
        var sum = 0.0
        for (i in 0 until 4) {
            map[x][y] = true
            sum += dfs(n - 1, x + offset[i][0], y + offset[i][1]) * probability[i]
            map[x][y] = false
        }
        return sum
    }

    val result = 1 - dfs(n, 14, 14)
    println(result)
}

//첫 번째 접근
/*
fun boj1405(input: String) {
    val param = input.split(" ")
    val n = param[0].toInt()
    val probability = param.subList(1, param.size).map { it.toDouble() / 100 }
    val answerMap = mutableMapOf<String, Double>()
    val offset =
        arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1))

    fun probabilityOf(answer: IntArray): Double {
        val str = answer.joinToString(",")
        if (str in answerMap)
            return answerMap[str]!!
        val prob = probability[0].pow(answer[0]) *
                probability[1].pow(answer[1]) *
                probability[2].pow(answer[2]) *
                probability[3].pow(answer[3])
        answerMap[str] = prob
        return 0.1
    }

    fun dfs(
        n: Int,
        history: Set<Pair<Int, Int>>,
        curr: Pair<Int, Int>,
        count: IntArray,
    ): Double {
        if (curr in history)
            return probabilityOf(count)
        if (n == 0)
            return 0.0
        var sum = 0.0
        for (i in 0 until 4) {
            count[i]++
            sum += dfs(n - 1,
                history + curr,
                curr.first + offset[i][0] to curr.second + offset[i][1],
                count)
            count[i]--
        }
        return sum
    }

    println(1 - dfs(n, mutableSetOf(), 0 to 0, IntArray(4)))
}
*/

// 두 번째 접근
/*
fun boj1405(input: String) {
    val param = input.split(" ")
    val n = param[0].toInt()
    val probability = param.subList(1, param.size).map { it.toDouble() / 100 }
    val offset =
        arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    val map = Array(29) { IntArray(29) }

    fun probabilityOf(answer: IntArray): Double {
        return probability[0].pow(answer[0]) *
                probability[1].pow(answer[1]) *
                probability[2].pow(answer[2]) *
                probability[3].pow(answer[3])
    }

    fun dfs(
        n: Int,
        curr: Pair<Int, Int>,
        count: IntArray,
    ): Double {
        if (map[curr.first][curr.second] > 0)
            return probabilityOf(count)
        if (map[14][14] == 0)
            map[14][14] = 1
        if (n == 0)
            return 0.0
        var sum = 0.0
        for (i in 0 until 4) {
            if (probability[i] < 0.001)
                continue
            count[i]++
            map[curr.first][curr.second]++
            sum += dfs(n - 1,
                curr.first + offset[i][0] to curr.second + offset[i][1],
                count)
            map[curr.first][curr.second]--
            count[i]--
        }
        return sum
    }

    val result = 1 - dfs(n, 14 to 14, IntArray(4))
    println(result)
}
*/

// 세 번째 접근
/*
fun boj1405(input: String) {
    val param = input.split(" ")
    val n = param[0].toInt()
    val probability = param.subList(1, param.size).map { it.toDouble() / 100 }
    val offset =
        arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    val map = Array(29) { BooleanArray(29) }

    fun probabilityOf(answer: IntArray): Double {
        return probability[0].pow(answer[0]) *
                probability[1].pow(answer[1]) *
                probability[2].pow(answer[2]) *
                probability[3].pow(answer[3])
    }

    fun dfs(n: Int, x: Int, y: Int, count: IntArray): Double {
        if (map[x][y])
            return probabilityOf(count)
        if (n == 0)
            return 0.0
        var sum = 0.0
        for (i in 0 until 4) {
            count[i]++
            map[x][y] = true
            sum += dfs(n - 1, x + offset[i][0], y + offset[i][1], count)
            map[x][y] = false
            count[i]--
        }
        return sum
    }

    val result = 1 - dfs(n, 14, 14, IntArray(4))
    println(result)
}
 */
