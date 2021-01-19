package codinginterview.nonlinear.tree

fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null) {
        return t2
    } else if (t2 == null) {
        return t1
    }

    t1.left = mergeTrees(t1.left, t2.left)
    t1.right = mergeTrees(t1.right, t2.right)
    t1.`val` += t2.`val`

    return t1
}