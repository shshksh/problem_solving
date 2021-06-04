package boj

/*
Source: 백준 14500 테트로미노(https://www.acmicpc.net/problem/14500)
Solved: O
Approach: 완전 탐색
Review:
- 각각의 테트로미노를 회전하거나 대칭하여 만들 수 있는 모든 경우의 수를 미리 정의. 테트로미노는 시작지점
부터 상대적 좌표 위치를 사용하여 정의. 맵의 모든 셀을 순회하며 각각의 셀을 시작지점으로 테트로미노를 만들
었을 때 최대값을 비교하여 모든 경우의 수를 완전 탐색.
 */

import java.io.BufferedReader
import java.io.InputStreamReader

private val tetrominos = arrayOf(
    arrayOf(0 to 0, 0 to 1, 1 to 0, 1 to 1), // 네모
    arrayOf(0 to 0, 0 to 1, 0 to 2, 0 to 3), // 일자
    arrayOf(0 to 0, 1 to 0, 2 to 0, 3 to 0), // 일자
    arrayOf(0 to 0, 1 to 0, 1 to 1, 2 to 1), // 번개
    arrayOf(0 to 0, 0 to 1, -1 to 1, -1 to 2), // 번개
    arrayOf(0 to 0, 1 to 0, 1 to -1, 2 to -1), // 번개
    arrayOf(0 to 0, 0 to 1, 1 to 1, 1 to 2), // 번개
    arrayOf(0 to 0, 1 to 0, 2 to 0, 2 to 1), // 기역
    arrayOf(0 to 0, 1 to 0, 0 to 1, 0 to 2), // 기역
    arrayOf(0 to 0, 0 to 1, 1 to 1, 2 to 1), // 기역
    arrayOf(0 to 0, 0 to 1, 0 to 2, -1 to 2), // 기역
    arrayOf(0 to 0, 1 to 0, 2 to 0, 2 to -1), // 기역
    arrayOf(0 to 0, 1 to 0, 1 to 1, 1 to 2), // 기역
    arrayOf(0 to 0, 0 to 1, 0 to 2, 1 to 2), // 기역
    arrayOf(0 to 0, 0 to 1, 1 to 0, 2 to 0), // 기역
    arrayOf(0 to 0, 0 to 1, 0 to 2, 1 to 1), // ㅗ
    arrayOf(0 to 0, 1 to 0, 2 to 0, 1 to -1), // ㅗ
    arrayOf(0 to 0, 0 to 1, 0 to 2, -1 to 1), // ㅗ
    arrayOf(0 to 0, 1 to 0, 2 to 0, 1 to 1), // ㅗ
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (height, width) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(height) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    println(boj14500(width, height, arr))
}

fun boj14500(width: Int, height: Int, arr: Array<IntArray>): Int {
    var max = 0
    for (x in 0 until height) {
        for (y in 0 until width) {
            max = maxOf(max, calcSum(arr, x, y))
        }
    }
    return max
}

private fun calcSum(arr: Array<IntArray>, x: Int, y: Int): Int {
    var sum = 0
    outer@ for (tetromino in tetrominos) {
        var temp = 0
        for (i in 0..3) {
            val (tx, ty) = x + tetromino[i].first to y + tetromino[i].second
            if (isValid(arr, tx, ty))
                temp += arr[tx][ty]
            else
                continue@outer
        }
        sum = maxOf(sum, temp)
    }
    return sum
}

fun isValid(arr: Array<IntArray>, x: Int, y: Int): Boolean {
    val (height, width) = arr.size to arr[0].size
    if (x < 0 || x >= height || y < 0 || y >= width)
        return false
    return true
}
