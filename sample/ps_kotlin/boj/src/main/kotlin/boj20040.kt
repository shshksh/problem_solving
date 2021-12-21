import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val unionArray = IntArray(n) { it }
    val sizeArray = IntArray(n) { 1 }

    for (i in 1..m) {
        val st = StringTokenizer(br.readLine(), " ")
        val p1 = st.nextToken().toInt()
        val p2 = st.nextToken().toInt()

        if (union(unionArray, sizeArray, p1, p2)) {
            println(i)
            return
        }
    }
    println(0)
}

private fun union(unionArray: IntArray, sizeArray: IntArray, p1: Int, p2: Int): Boolean {
    val p1root = find(unionArray, p1)
    val p2root = find(unionArray, p2)

    if (p1root == p2root)
        return true
    if (sizeArray[p1root] > sizeArray[p2root]) {
        unionArray[p2root] = p1root
        sizeArray[p1root] += sizeArray[p2root]
    } else {
        unionArray[p1root] = p2root
        sizeArray[p2root] += sizeArray[p1root]
    }
    return false
}

fun find(unionArray: IntArray, p: Int): Int {
    var curr = p
    while (curr != unionArray[curr]) {
        unionArray[curr] = unionArray[unionArray[curr]]
        curr = unionArray[curr]
    }
    return curr
}
