package codinginterview.nonlinear.tree

import java.lang.Integer.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return max(maxDepth(root.left), maxDepth(root.right)) + 1
}