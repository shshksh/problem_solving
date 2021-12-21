package nonlinear.tree

fun bstToGst(root: TreeNode?): TreeNode? {
    var acc = 0

    fun dfs(node: TreeNode?) {
        node ?: return

        dfs(node.right)
        node.`val` += acc
        acc = node.`val`
        dfs(node.left)
    }

    dfs(root)

    return root
}
