package hyperskill.minesweeper

import java.lang.StringBuilder
import java.util.*
import kotlin.random.Random

fun main() {
    val rand = Random(System.currentTimeMillis())
    val line = StringBuilder("""
        .........
        .........
        .........
        .........
        .........
        .........
        .........
        .........
        .........
    """.trimIndent())

    val sc = Scanner(System.`in`)
    print("How many mines do you want on the field? ")
    var mineCnt = sc.nextInt()

    while (mineCnt > 0) {
        val minePosition = rand.nextInt(80)
        if (line[minePosition] == '.') {
            line[minePosition] = 'X'
            mineCnt--
        }
    }

    println(line)
}
