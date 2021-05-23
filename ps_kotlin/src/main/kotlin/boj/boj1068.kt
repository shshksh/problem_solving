package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val tree = br.readLine().split(" ").map { it.toInt() }
    val target = br.readLine().toInt()

    println(leafOf(n, tree, target))
}

fun leafOf(n: Int, tree: List<Int>, target: Int): Int {
    class Node {
        val children = mutableListOf<Node>()
    }

    val node = tree.map { Node() }
    var root: Node? = null

    tree.forEachIndexed { index, i ->
        if (i >= 0 && index != target) {
            node[i].children.add(node[index])
        } else if (i < 0 && index != target) {
            root = node[index]
        }
    }

    if (root == null)
        return 0

    fun dfs(root: Node): Int {
        if (root.children.isEmpty())
            return 1
        var sum = 0
        for (child in root.children) {
            sum += dfs(child)
        }
        return sum
    }

    return dfs(root!!)
}