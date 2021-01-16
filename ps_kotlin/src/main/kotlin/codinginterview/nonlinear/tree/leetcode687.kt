package codinginterview.nonlinear.tree

fun longestUnivaluePath(root: TreeNode?): Int {
    var result = 0

    fun dfs(root: TreeNode?): Int {
        if (root == null)
            return 0
        var leftDepth = dfs(root.left)
        var rightDepth = dfs(root.right)

        if (root.left != null && root.`val` == root.left!!.`val`) {
            leftDepth += 1
        } else {
            leftDepth = 0
        }
        if (root.right != null && root.`val` == root.right!!.`val`) {
            rightDepth += 1
        } else {
            rightDepth = 0
        }

        result = maxOf(result, leftDepth + rightDepth)

        return maxOf(leftDepth, rightDepth)
    }

    dfs(root)

    return result
}