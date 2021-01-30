package codinginterview.nonlinear.tree

class Solution {
    var sum = 0

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        root ?: return 0

        rangeSumBST(root.left, low, high)
        if (root.`val` in low..high) {
            sum += root.`val`
        }
        rangeSumBST(root.right, low, high)

        return sum
    }
}