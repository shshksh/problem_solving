package signature

import java.util.*
import kotlin.math.max

const val symbolTop = ("""____ ___  ____ ___  ____ ____ ____ _  _ _  _ _  _ _    _  _ _  _ ____ ___  ____ ____ ____ ___ _  _ _  _ _ _ _ _  _ _   _ ___ """)
const val symbolMid = ("""|__| |__] |    |  \ |___ |___ | __ |__| |  | |_/  |    |\/| |\ | |  | |__] |  | |__/ [__   |  |  | |  | | | |  \/   \_/    / """)
const val symbolBtm = ("""|  | |__] |___ |__/ |___ |    |__] |  | | _| | \_ |___ |  | | \| |__| |    |_\| |  \ ___]  |  |__|  \/  |_|_| _/\_   |    /__""")
const val space = "    "
val symbolWidth = listOf(4, 4, 4, 4, 4, 4, 4, 4, 1, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 4, 4, 5, 4, 5, 4)

fun main() {
    val listTop = splitSymbols(symbolTop)
    val listMid = splitSymbols(symbolMid)
    val listBtm = splitSymbols(symbolBtm)

    val sc = Scanner(System.`in`)
    print("Enter name and surname: ")
    val name = sc.nextLine().toLowerCase()
    print("Enter person's status: ")
    val status = sc.nextLine()

    val width = max(name.sumBy { c ->
        if (c in 'a'..'z')
            symbolWidth[c.toInt() - 'a'.toInt()]
        else
            return@sumBy 4
    } + name.length + 5, status.length + 6)

    printEdge(width)
    printBody(listTop, name, width)
    printBody(listMid, name, width)
    printBody(listBtm, name, width)
    printBody(name = status, width = width)
    printEdge(width)
}

fun printBody(list: List<String> = listOf(), name: String = "", width: Int = 0) {
    val sj = StringJoiner(" ", "*  ", "  *")
    val sb = StringBuilder()
    for (i in 0 until width - 6) {
        sb.append(" ")
    }

    val replace = if (list.isNotEmpty()) {
        name.map { c ->
            when (c) {
                ' ' -> "    "
                else -> list[c.toInt() - 'a'.toInt()]
            }
        }.joinToString(" ")
    } else {
        name
    }

    val start = if (sb.length % 2 + 1 == replace.length % 2)
        sb.length / 2 - (replace.length + 1) / 2
    else
        sb.length / 2 - replace.length / 2

    sb.replace(start, start + replace.length, replace)
    sj.add(sb.toString())

    println(sj.toString())
}

fun printEdge(width: Int) {
    val sb = StringBuilder()
    for (i in 0 until width)
        sb.append("*")
    println(sb.toString())
}

fun splitSymbols(line: String): List<String> {
    val sb = StringBuilder(line)
    val list = mutableListOf<String>()
    var index = 0

    for (width in symbolWidth) {
        list += sb.substring(index until index + width)
        index += width + 1
    }

    return list
}

val s = """
*********************
*  _  _      _   _  *
*   \/        \_/   *
*  _/\_        |    *
*      Status       *
*********************
""".trimIndent()

val t = """
*********************
*  _  _      _   _  *
*   \/        \_/   *
*  _/\_        |    *
*      Status       *
*********************
""".trimIndent()
val z = """
*********************
*  _  _      _   _  *
*   \/        \_/   *
*  _/\_        |    *
*      Statusa      *
*********************
""".trimIndent()
val k = """
*********************
*  _  _      _   _  *
*   \/        \_/   *
*  _/\_        |    *
*      Status       *
*********************
"""