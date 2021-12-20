private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()
fun main() {

    val n = br.readLine().toInt()
    val inorder = br.readLine().split(" ").map { it.toInt() }
    val postorder = br.readLine().split(" ").map { it.toInt() }

    preorder(inorder, postorder)
    bw.flush()
}

private fun preorder(inorder: List<Int>, postorder: List<Int>) {
    if (inorder.isEmpty() || postorder.isEmpty())
        return
    bw.write("${postorder.last()} ")
    val split = inorder.indexOf(postorder.last())
    preorder(inorder.subList(0, split), postorder.subList(0, split))
    preorder(inorder.subList(split + 1, inorder.size), postorder.subList(split, postorder.lastIndex))
}
