import kotlin.math.abs

fun main() {
    val target = readLine()!!
    val count = readLine()!!.toInt()
    val broken = if (count == 0) "" else readLine()!!

    println(boj1107(target, broken))
}

fun boj1107(
    target: String,
    broken: String,
): Int {
    val targetNumber = target.toInt()
    val brokenNumber = broken.split(" ")
    val range = Array(10) { "$it" }.filter { it !in brokenNumber }

    var min = abs(100 - targetNumber)
    if ("0" in range)
        min = minOf(min, targetNumber + 1)

    fun dfs(acc: String) {
        val result = abs(acc.toInt() - targetNumber) + acc.length
        min = minOf(min, result)

        if (acc.toInt() > targetNumber)
            return

        for (s in range) {
            dfs(acc + s)
        }
    }

    for (s in (range - "0")) {
        dfs(s)
    }

    return min
}
