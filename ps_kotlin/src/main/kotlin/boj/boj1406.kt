package boj

fun main() {
    class Node(var value: Char?, var left: Node? = null, var right: Node? = null)

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var cursor: Node? = Node(null)
    for (c in br.readLine()) {
        cursor?.right = Node(c, cursor)
        cursor = cursor?.right
    }
    val n = br.readLine().toInt()

    repeat(n) {
        val command = br.readLine().split(" ")
        when (command[0]) {
            "L" -> if (cursor?.left != null) cursor = cursor?.left
            "D" -> if (cursor?.right != null) cursor = cursor?.right
            "B" -> {
                if (cursor?.value != null) {
                    cursor?.left?.right = cursor?.right
                    cursor?.right?.left = cursor?.left
                    cursor = cursor?.left
                }
            }
            "P" -> {
                cursor?.right = Node(command[1][0], cursor, cursor?.right)
                if (cursor?.right?.right != null)
                    cursor?.right?.right?.left = cursor?.right
                cursor = cursor?.right
            }
        }
    }
    while (cursor?.value != null)
        cursor = cursor?.left
    cursor = cursor?.right

    while (cursor != null) {
        bw.write("${cursor?.value}")
        cursor = cursor?.right
    }
    bw.flush()
}