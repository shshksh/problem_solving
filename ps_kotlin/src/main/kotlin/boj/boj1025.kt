package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

var n = 0
var m = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").let {
        n = it[0].toInt()
        m = it[1].toInt()
    }

//    val arr = br.readLines()
    val arr = mutableListOf<String>()
    for (i in 1..n) {
        arr.add(br.readLine())
    }

    var maxSquare = -1
    for (i in 0 until n) {
        for (j in 0 until m) {
            findMaxSquare(arr, i, j).let {
//                println(it)
                maxSquare = maxOf(maxSquare, it)
            }
        }
    }
    println(maxSquare)
}

fun findMaxSquare(arr: List<String>, i: Int, j: Int): Int {
    val rowRange = 1 - n until n
    val colRange = 1 - m until m
    var max = -1

    for (rowDiff in rowRange) {
        for (colDiff in colRange) {
            var x = i
            var y = j

            var acc = arr[i][j].toString()
            if (rowDiff == 0 && colDiff == 0)
            else
                while (x + rowDiff in 0 until n && y + colDiff in 0 until m) {
                    x += rowDiff
                    y += colDiff
                    acc += arr[x][y]
                    val target = acc.toInt()
                    if (isSquare(target))
                        max = maxOf(max, target)
                }
            val target = acc.toInt()
            if (isSquare(target))
                max = maxOf(max, target)
        }
    }
    return max
}

fun isSquare(target: Int): Boolean {
    for (i in 0..sqrt(target.toDouble()).toInt()) {
        if (i * i == target)
            return true
    }
    return false
}
/*
6 9
111111111
611111111
117111111
111141111
111111511
111111111

9 9
222222222
222222222
222222222
222222222
222222222
222222222
222222222
222222222
222222222

9 9
222222222
222222222
222222222
226222222
222272222
222222422
222222225
222222222
222222222

9 9
444444444
444444444
444444444
444444444
444444444
444444444
444444444
444444444
444444444

9 9
999999999
999999999
999999999
999999999
999999999
999999999
999999999
999999999
999999999

8 8
10000000
00000000
00000000
00000000
00008000
00000900
00000090
00000009

8 8
01234321
92718406
99999099
99990999
99989999
78996544
99999999
99999999
 */