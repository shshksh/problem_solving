package hyperskill.minesweeper

import java.util.*

private val mines = mutableSetOf<Pair<Int, Int>>()
private val chkSet = mutableSetOf<Pair<Int, Int>>()
private val unChkSet = mutableSetOf<Pair<Int, Int>>()
private const val UNEXPLORED = '.'
private const val MARKED = '*'
private const val FREE = '/'
private const val MINE = 'X'

fun main() {
    initSet()
    val map = initMap()
    val userMap = initMap()

    val sc = Scanner(System.`in`)
    print("How many mines do you want on the field? ")
    val mineCnt = sc.nextInt()

    mining(map, mineCnt)
    printMap(userMap)

    while ((chkSet + unChkSet) != mines ) {
        val (x, y, option) = inputCommand(sc)

        when (option) {
            "mine" ->
                userMap[y][x] = when (userMap[y][x]) {
                    MARKED -> {
                        chkSet.remove(y to x)
                        UNEXPLORED
                    }
                    UNEXPLORED -> {
                        chkSet.add(y to x)
                        MARKED
                    }
                    else -> userMap[y][x]
                }
            "free" ->
                when (map[y][x]) {
                    MINE -> {
                        for ((i, j) in mines) {
                            userMap[i][j] = MINE
                        }
                        printMap(userMap)
                        println("You stepped on a mine and failed!")
                        return
                    }
                    else -> reveal(y, x, map, userMap)
                }
        }
        printMap(userMap)
    }
    println("Congratulations! You found all the mines!")
}

private fun initSet() {
    for (i in 0..8) {
        for (j in 0..8) {
            unChkSet.add(i to j)
        }
    }
}

private fun reveal(x: Int, y: Int, map: MutableList<MutableList<Char>>, userMap: MutableList<MutableList<Char>>) {
    if (x in 0..8 && y in 0..8 && map[x][y] != FREE) {
        when (map[x][y]) {
            in '0'..'9' -> {
                userMap[x][y] = map[x][y]
                unChkSet.remove(x to y)
            }
            UNEXPLORED -> {
                map[x][y] = FREE
                userMap[x][y] = map[x][y]
                unChkSet.remove(x to y)
                reveal(x-1, y-1, map, userMap)
                reveal(x-1, y, map, userMap)
                reveal(x-1, y+1, map, userMap)
                reveal(x, y-1, map, userMap)
                reveal(x, y+1, map, userMap)
                reveal(x+1, y-1, map, userMap)
                reveal(x+1, y, map, userMap)
                reveal(x+1, y+1, map, userMap)
            }
        }
    }
}

private fun inputCommand(sc: Scanner): Triple<Int, Int, String> {
    print("Set/unset mines marks or claim a cell as free: ")
    val x = sc.nextInt() - 1
    val y = sc.nextInt() - 1
    val option = sc.next()
    return Triple(x, y, option)
}

private fun initMap(): MutableList<MutableList<Char>> {
    val map = mutableListOf<MutableList<Char>>()
    repeat(9) { map.add(MutableList(9) { _ -> '.' }) }
    return map
}

private fun printMap(map: MutableList<MutableList<Char>>) {
    println(" |123456789|")
    println("-|---------|")
    for ((i, list) in map.withIndex()) {
        println(list.joinToString(separator = "", prefix = "${i + 1}|", postfix = "|"))
    }
    println("-|---------|")
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
