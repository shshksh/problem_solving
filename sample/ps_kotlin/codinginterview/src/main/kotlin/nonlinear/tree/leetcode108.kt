package nonlinear.tree

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty())
        return null

    fun split(root: TreeNode, slice: IntArray) {
        if (slice.isEmpty()) {
            return
        }

        val mid = slice.size / 2
        val node = TreeNode(slice[mid])
        if (node.`val` <= root.`val`)
            root.left = node
        else
            root.right = node
        split(node, slice.sliceArray(0 until mid))
        split(node, slice.sliceArray(mid + 1 until slice.size))
    }

    val mid = nums.size / 2
    val root = TreeNode(nums[mid])
    split(root, nums.sliceArray(0 until mid))
    split(root, nums.sliceArray(mid + 1 until nums.size))

    return root
}
