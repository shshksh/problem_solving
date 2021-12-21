fun main() {
    val br = System.`in`.bufferedReader()

    val (nodeCount, searchLimit, edgeCount) = br.readLine().split(" ").map { it.toInt() }

    val itemList = br.readLine().split(" ").map { it.toInt() }

    val weightArray = Array(nodeCount) { IntArray(nodeCount) { 10000000 } }

    for (edge in 1..edgeCount) {
        val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
        weightArray[from - 1][to - 1] = weight
        weightArray[to - 1][from - 1] = weight
    }

    for (k in 0 until nodeCount)
        for (i in 0 until nodeCount)
            for (j in 0 until nodeCount) {
                if (i == j) continue
                weightArray[i][j] = minOf(weightArray[i][j], weightArray[i][k] + weightArray[k][j])
            }

    var max = 0
    for (i in 0 until nodeCount) {
        var sum = itemList[i]
        for ((j, weight) in weightArray[i].withIndex()) {
            if (weight <= searchLimit)
                sum += itemList[j]
        }
        max = maxOf(max, sum)
    }

    println(max)
}
