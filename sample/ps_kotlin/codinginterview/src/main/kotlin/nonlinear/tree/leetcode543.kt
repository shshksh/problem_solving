package nonlinear.tree

import java.lang.Integer.max

fun diameterOfBinaryTree(root: TreeNode?): Int {

    var diameter = 0

    fun dfs(root: TreeNode?): Int {
        if (root == null)
            return 0;
        val left = dfs(root.left)
        val right = dfs(root.right)
        diameter = max(diameter, left + right)
        return max(left, right) + 1
    }
    dfs(root)

    return diameter
}
