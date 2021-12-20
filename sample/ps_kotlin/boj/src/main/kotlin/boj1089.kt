fun main() {
    val br = System.`in`.bufferedReader()
    val numbers = arrayOf(
        "###...#.###.###.#.#.###.###.###.###.###",
        "#.#...#...#...#.#.#.#...#.....#.#.#.#.#",
        "#.#...#.###.###.###.###.###...#.###.###",
        "#.#...#.#.....#...#...#.#.#...#.#.#...#",
        "###...#.###.###...#.###.###...#.###.###"
    )

    val n = br.readLine().toInt()
    val floor = Array(5) { br.readLine() }

    val result = Array(n) { mutableListOf<Int>() }

    for (i in 0 until 4 * n step 4) {
        for (j in 0 until 40 step 4) {
            var flag = true
            for (k in 0..4) {
                flag = flag && isMatch(
                    floor[k].slice(i until i + 3), numbers[k].slice(j until j + 3)
                )
                if (!flag)
                    break
            }
            if (flag)
                result[i / 4].add(j / 4)
        }
    }

    var bias = 1
    var avg = 0.0

    for (i in result.size - 1 downTo 0) {
        avg += result[i].average() * bias
        bias *= 10
    }

    if (avg.isNaN()) println(-1) else println(avg)
}

private fun isMatch(a: String, b: String): Boolean {
    for (i in a.indices) {
        if (a[i] == '#')
            if (b[i] != '#')
                return false
    }
    return true
}
