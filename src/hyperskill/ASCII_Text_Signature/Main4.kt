package signature

import java.io.File
import java.lang.StringBuilder
import java.util.*

class Letter {
    var width: Int = 0
    val list = mutableListOf<String>()
}

val romanMap = mutableMapOf<Char, Letter>()
val mediumMap = mutableMapOf<Char, Letter>()
const val romanSpace: String = "          "
const val mediumSpace: String = "     "

fun main() {
    init()
    val sc = Scanner(System.`in`)
    print("Enter name and surname: ")
    val name = sc.nextLine()
    print("Enter person's status: ")
    val status = sc.nextLine()

    val width = maxOf(name.sumBy {
        romanMap[it]!!.width
    }, status.sumBy {
        mediumMap[it]!!.width
    }) + 8

    printEdge(width)
    printBody(name, width, 10, romanMap)
    printBody(status, width, 3, mediumMap)
    printEdge(width)
}

fun printBody(name: String, width: Int, height: Int, map: MutableMap<Char, Letter>) {
    val sb = StringBuilder()
    repeat(width - 4) { sb.append(" ") }
    for (i in 0 until height) {
        val replace = name.map { c ->
            map[c]?.list?.get(i)
        }.joinToString("")

        val start = if (sb.length % 2 + 1 == replace.length % 2)
            sb.length / 2 - (replace.length + 1) / 2
        else
            sb.length / 2 - replace.length / 2

        sb.replace(start, start + replace.length, replace)
        println("88${sb}88")
    }
}

fun printEdge(width: Int) {
    val sb = StringBuilder()
    repeat(width) { sb.append("8") }
    println(sb.toString())
}

fun init() {
    val sc1 = Scanner(File("C:/fonts/roman.txt"))
    val sc2 = Scanner(File("C:/fonts/medium.txt"))
    initMap(sc1, romanMap)
    romanMap[' '] = Letter()
    romanMap[' ']?.width = 10
    repeat(10) {
        romanMap[' ']?.list?.add(romanSpace)
    }
    initMap(sc2, mediumMap)
    mediumMap[' '] = Letter()
    mediumMap[' ']?.width = 5
    repeat(3) {
        mediumMap[' ']?.list?.add(mediumSpace)
    }
}

fun initMap(sc: Scanner, map: MutableMap<Char, Letter>) {
    val height = sc.nextInt()
    val n = sc.nextInt()

    for (i in 0 until n) {
        val char = sc.next()[0]
        val width = sc.nextInt()
        sc.nextLine()

        map[char] = Letter()
        map[char]?.width = width

        repeat(height) {
            map[char]?.list?.add(sc.nextLine())
        }
    }
}