package hyperskill.minesweeper

import java.util.*
import kotlin.random.Random

private val mines = mutableSetOf<Pair<Int, Int>>()

fun main() {
    val rand = Random(System.currentTimeMillis())
    val map = mutableListOf<MutableList<Char>>()
    repeat(9) { map.add(MutableList(9) { _ -> '.' }) }

    val sc = Scanner(System.`in`)
    print("How many mines do you want on the field? ")
    val mineCnt = sc.nextInt()
    val chkSet = mutableSetOf<Pair<Int, Int>>()

    mining(map, mineCnt)
    hideMine(map)
    printMap(map)

    while (chkSet != mines) {
        print("Set/delete mines marks (x and y coordinates): ")
        val x = sc.nextInt() - 1
        val y = sc.nextInt() - 1

        if (map[y][x] in '0'..'9') {
            println("There is a number here!")
        } else {
            map[y][x] = if (map[y][x] == '*') {
                chkSet.remove(y to x)
                '.'
            } else {
                chkSet.add(y to x)
                '*'
            }
            printMap(map)
        }
    }
    println("Congratulations! You found all the mines!")
}

private fun printMap(map: MutableList<MutableList<Char>>) {
    println(" |123456789|")
    println("-|---------|")
    for ((i, list) in map.withIndex()) {
        println(list.joinToString(separator = "", prefix = "${i + 1}|", postfix = "|"))
    }
    println("-|---------|")
}

private fun hideMine(map: MutableList<MutableList<Char>>) {
    mines.forEach { (x, y) -> map[x][y] = '.' }
}

private fun hintMine(map: MutableList<MutableList<Char>>, x: Int, y: Int) {
    for (i in x - 1..x + 1) {
        for (j in y - 1..y + 1) {
            if (i in 0..8 && j in 0..8 && map[i][j] != 'X') {
                map[i][j] = if (map[i][j] == '.') '1' else map[i][j] + 1
            }
        }
    }
}

private fun mining(map: MutableList<MutableList<Char>>, mineCnt: Int) {
    (0..80).toList().shuffled().take(mineCnt).forEach {
        map[it / 9][it % 9] = 'X'
        hintMine(map, it / 9, it % 9)
        mines.add(it / 9 to it % 9)
    }
}

