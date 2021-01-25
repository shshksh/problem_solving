package codinginterview.nonlinear.tree;

fun isBalanced(root: TreeNode?): Boolean {
    var result = true
    fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0;
        }
        val leftDepth = dfs(root.left)
        val rightDepth = dfs(root.right)
        println("val = ${root.`val`}, ld = $leftDepth, rd = $rightDepth")
        result = result && (leftDepth - rightDepth <= 1 && leftDepth - rightDepth >= -1)
        return maxOf(leftDepth, rightDepth) + 1
    }
    dfs(root)

    return result
}