package hyperskill.minesweeper

import java.lang.StringBuilder
import kotlin.random.Random

fun main() {
    val rand = Random(System.currentTimeMillis())
    repeat(9) {
        val line = StringBuilder("********")
        repeat(2) {
            line[rand.nextInt(8)] = 'X'
        }
        println(line)
    }
}
