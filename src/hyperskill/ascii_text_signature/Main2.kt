package hyperskill.ascii_text_signature

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val firstName = sc.next()
    val lastName = sc.next()
    val body = "* $firstName $lastName *"

    printEdge(body)
    println(body)
    printEdge(body)
}

private fun printEdge(body: String) {
    for (i in body.indices) {
        print("*")
    }
    println()
}
