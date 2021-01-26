package codinginterview.nonlinear.tree

import java.util.*

/*fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()
    val edgeMap = mutableMapOf<Int, MutableList<Int>>()
    var minHeight = n / 2

    edges.forEach {
        edgeMap.getOrPut(it[0]) { mutableListOf() }.add(it[1])
        edgeMap.getOrPut(it[1]) { mutableListOf() }.add(it[0])
    }

    for (i in 0 until n) {
        val visitedSet = mutableSetOf<Int>()
        var depth = -1
        val q = LinkedList<Int>()
        q.offer(i)

        while (!q.isEmpty() && depth <= minHeight) {
            val size = q.size
            depth++
            for (j in 0 until size) {
                val node = q.poll()
                visitedSet.add(node)

                edgeMap[node]?.let {
                    it.forEach { node ->
                        if (node !in visitedSet) {
                            q.offer(node)
                        }
                    }
                }
            }
        }
        if (depth < minHeight) {
            result.clear()
            result.add(i)
            minHeight = depth
        } else if (depth == minHeight) {
            result.add(i)
        }
    }

    return result
}*/

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n <= 1)
        return listOf(0)

    val edgeMap = mutableMapOf<Int, MutableList<Int>>()
    edges.forEach {
        edgeMap.getOrPut(it[0]) { mutableListOf() }.add(it[1])
        edgeMap.getOrPut(it[1]) { mutableListOf() }.add(it[0])
    }

    var leaves = mutableListOf<Int>()
    edgeMap.forEach { (t, u) ->
        if (u.size == 1)
            leaves.add(t)
    }

    var size = n
    while (size > 2) {
        size -= leaves.size
        val newLeaves = mutableListOf<Int>()
        for (leaf in leaves) {
            val parent = edgeMap.remove(leaf)?.get(0)
            parent?.let { edgeMap[parent]?.remove(leaf) }

            parent?.let {
                if (edgeMap[parent]?.size == 1) {
                    newLeaves.add(parent)
                }
            }
        }
        leaves = newLeaves
    }

    return leaves
}