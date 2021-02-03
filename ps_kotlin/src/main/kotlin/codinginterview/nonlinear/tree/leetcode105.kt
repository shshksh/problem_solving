package codinginterview.nonlinear.tree

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) {
        return null
    }
    val root = TreeNode(preorder[0])
    val rootIdx = inorder.indexOf(preorder[0])

    val leftInorder = inorder.sliceArray(0 until rootIdx)
    val rightInorder = inorder.sliceArray(rootIdx + 1 until inorder.size)

    root.left = buildTree(
        preorder.drop(1).take(leftInorder.size).toIntArray(),
        leftInorder
    )
    root.right = buildTree(
        preorder.takeLast(rightInorder.size).toIntArray(),
        rightInorder
    )

    return root
}