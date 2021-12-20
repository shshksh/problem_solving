fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val check = BooleanArray(n + 1)
    val weightArray = LongArray(n + 1) { Int.MAX_VALUE.toLong() }
    val prevArray = Array<Int?>(n + 1) { null }

    val adjArr = Array(n + 1) { LongArray(n + 1) { 200000000 } }

    for (i in 1..m) {
        val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
        if (weight < adjArr[from][to])
            adjArr[from][to] = weight.toLong()
    }

    val (from, to) = br.readLine().split(" ").map { it.toInt() }

    var curr = from
    weightArray[from] = 0
    while (true) {
        if (check[curr]) continue
        check[curr] = true
        if (curr == to) break

        for ((i, weight) in adjArr[curr].withIndex()) {
            if (weightArray[i] > weightArray[curr] + weight) {
                weightArray[i] = weightArray[curr] + weight
                prevArray[i] = curr
            }
        }

        curr = 0
        for (i in weightArray.indices) {
            if (!check[i] && weightArray[i] < weightArray[curr])
                curr = i
        }
    }

    println(weightArray[to])
    val path = mutableListOf<Int>()
    var current: Int? = to
    while (current != null) {
        path.add(current)
        current = prevArray[current]
    }
    println(path.size)
    println(path.reversed().joinToString(" "))
}
