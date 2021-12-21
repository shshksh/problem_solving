fun main() {
    class Node(
        val number: Int,
        val adj: MutableList<Pair<Node, Int>> = mutableListOf()
    )

    val br = System.`in`.bufferedReader()

    val size = br.readLine().toInt()

    val tree = mutableMapOf<Int, Node>()

    for (i in 1..size) {
        val connection = br.readLine().split(" ").map { it.toInt() }

        val node = tree.getOrPut(connection[0]) { Node(connection[0]) }

        for (j in 1..connection.size - 2 step 2) {
            val add = tree.getOrPut(connection[j]) { Node(connection[j]) }
            node.adj.add(add to connection[j + 1])
        }
    }

    val check = BooleanArray(size + 1)
    var max = 0L

    fun dfs(node: Node): Long {
        check[node.number] = true
        var first = 0L
        var second = 0L

        for ((adjNode, distance) in node.adj) {
            if (check[adjNode.number]) continue

            val depth = dfs(adjNode) + distance
            if (depth >= first) {
                second = first
                first = depth
            } else if (depth > second) {
                second = depth
            }
        }
        max = maxOf(max, first + second)

        return first
    }

    dfs(tree.getValue(1))

    println(max)
}

/*
13
1 2 10 3 10 -1
2 1 10 4 10 5 10 -1
3 1 10 6 200 7 300 -1
4 2 10 8 200 9 10 -1
5 2 10 -1
6 3 200 -1
7 3 300 -1
8 4 200 -1
9 4 10 10 700 11 50 12 100 13 800 -1
10 9 700 -1
11 9 50 -1
12 9 100 -1
13 9 800 -1
 */

/*
2
1 2 10 -1
2 1 10 -1
 */
