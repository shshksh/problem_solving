private val bw = System.out.bufferedWriter()

fun main() {
    val br = System.`in`.bufferedReader()
    val tree = br.readLines().map {it.toInt()}

    pre2post(tree, 0, tree.size)
    bw.flush()
}

fun pre2post(tree: List<Int>, start: Int, end: Int) {
    if (start == end)
        return
    val root = tree[start]
    var mid = start + 1
    while (mid < end && tree[mid] < root)
        mid++

    pre2post(tree, start + 1, mid)
    pre2post(tree, mid, end)
    bw.write("$root\n")
}
