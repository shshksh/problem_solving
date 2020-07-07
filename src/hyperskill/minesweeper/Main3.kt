package hyperskill.minesweeper

import java.util.*
import kotlin.random.Random

fun main() {
    val rand = Random(System.currentTimeMillis())
    val map = mutableListOf<MutableList<Char>>()
    repeat(9) { map.add(MutableList(9) { _ -> '.' }) }

    val sc = Scanner(System.`in`)
    print("How many mines do you want on the field? ")
    val mineCnt = sc.nextInt()

    mining(map, mineCnt)

    for (mutableList in map) {
        for (c in mutableList) {
            print(c)
        }
        println()
    }
}

private fun hintMine(map: MutableList<MutableList<Char>>, x: Int, y: Int) {
    for (i in x - 1..x + 1) {
        for (j in y - 1..y + 1) {
            if (i in 0..8 && j in 0..8 && map[i][j] != 'X') {
                map[i][j] = if (map[i][j] == '.') '1' else map[i][j]+1
            }
        }
    }
}

private fun mining(map: MutableList<MutableList<Char>>, mineCnt: Int) {
    (0..80).toList().shuffled().take(mineCnt).forEach {
        map[it / 9][it % 9] = 'X'
        hintMine(map, it / 9, it % 9)
    }
}

