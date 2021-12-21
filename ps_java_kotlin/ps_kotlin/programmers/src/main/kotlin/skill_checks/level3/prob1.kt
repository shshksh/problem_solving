package skill_checks.level3

import java.util.*

fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
    val q = PriorityQueue<Pair<Int, IntArray>>(kotlin.Comparator { o1, o2 ->
        if (o1.second[1] == o2.second[1])
            o1.second[0] - o2.second[0]
        else
            o2.second[1] - o1.second[1]
    })

    for ((i, v) in nodeinfo.withIndex()) {
        q.add(i + 1 to v)
    }

    val tree = BST()

    while (q.isNotEmpty()) {
        tree.add(q.poll())
    }

    return arrayOf(tree.preOrder(tree.root), tree.postOrder(tree.root))
}

class BST {
    var root: Node? = null

    fun add(node: Pair<Int, IntArray>) {
        if (root == null)
            root = Node(node.first, node.second)
        else
            add(root!!, node.first, node.second)
    }

    private fun add(parent: Node, id: Int, position: IntArray) {
        if (position[0] < parent.position[0]) {
            if (parent.left != null) {
                add(parent.left!!, id, position)
            } else {
                parent.left = Node(id, position)
            }
        } else if (position[0] > parent.position[0]) {
            if (parent.right != null) {
                add(parent.right!!, id, position)
            } else {
                parent.right = Node(id, position)
            }
        }
    }

    fun preOrder(node: Node?): IntArray {
        if (node == null) {
            return intArrayOf()
        }
        return intArrayOf(node.id) + preOrder(node.left) + preOrder(node.right)
    }

    fun postOrder(node: Node?): IntArray {
        if (node == null) {
            return intArrayOf()
        }
        return postOrder(node.left) + postOrder(node.right) + intArrayOf(node.id)
    }
}

class Node(
    val id: Int,
    val position: IntArray,
    var left: Node? = null,
    var right: Node? = null
)

fun main() {
    for (ints in solution(arrayOf(
        intArrayOf(5, 3),
        intArrayOf(11, 5),
        intArrayOf(13, 3),
        intArrayOf(3, 5),
        intArrayOf(6, 1),
        intArrayOf(1, 3),
        intArrayOf(8, 6),
        intArrayOf(7, 2),
        intArrayOf(2, 2),
    ))) {
        println(ints.contentToString())
    }
}
