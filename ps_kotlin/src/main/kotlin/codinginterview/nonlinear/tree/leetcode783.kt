package codinginterview.nonlinear.tree

import kotlin.math.abs

var minDiff = Int.MAX_VALUE
var prevVal = Int.MAX_VALUE

fun minDiffInBST(root: TreeNode?): Int {
    root ?: return 0

    minDiffInBST(root.left)
    minDiff = minOf(minDiff, abs(prevVal - root.`val`))
    prevVal = root.`val`
    minDiffInBST(root.right)

    return minDiff
}