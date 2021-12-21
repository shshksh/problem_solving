fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val tree = mutableMapOf<String, Pair<String, String>>()

    for (i in 1..n) {
        val (root, l, r) = br.readLine().split(" ")
        tree[root] = l to r
    }

    fun preorder(root: String) {
        if (root == ".")
            return
        bw.write(root)
        preorder(tree[root]!!.first)
        preorder(tree[root]!!.second)
    }

    fun inorder(root: String) {
        if (root == ".")
            return
        inorder(tree[root]!!.first)
        bw.write(root)
        inorder(tree[root]!!.second)
    }

    fun postorder(root: String) {
        if (root == ".")
            return
        postorder(tree[root]!!.first)
        postorder(tree[root]!!.second)
        bw.write(root)
    }

    preorder("A")
    bw.newLine()
    inorder("A")
    bw.newLine()
    postorder("A")
    bw.flush()
}
