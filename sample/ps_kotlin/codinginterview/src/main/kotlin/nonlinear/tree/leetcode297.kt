package nonlinear.tree

import java.util.*

class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val q = LinkedList<TreeNode>()
        val sj = StringJoiner(",")

        q.offer(root)
        while (!q.isEmpty()) {
            val node = q.poll()
            sj.add(node?.`val`.toString())
            node?.let {
                q.offer(node.left)
                q.offer(node.right)
            }
        }

        return sj.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == "null") {
            return null
        }

        val arr = data.split(",")
        val q = LinkedList<TreeNode>()

        val root = TreeNode(arr[0].toInt())
        q.offer(root)
        var i = 1

        while (!q.isEmpty()) {
            val node = q.poll()

            val lValue = arr[i++]
            if (lValue != "null") {
                node.left = TreeNode(lValue.toInt())
                q.offer(node.left)
            }
            val rValue = arr[i++]
            if (rValue != "null") {
                node.right = TreeNode(rValue.toInt())
                q.offer(node.right)
            }
        }

        return root
    }
}
