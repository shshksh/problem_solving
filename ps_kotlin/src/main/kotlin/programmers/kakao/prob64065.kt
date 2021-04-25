package programmers.kakao

fun solution_(s: String): IntArray {
    val list = s.trim('{', '}')
        .split("}")
        .map { it.trim('{', ',').split(",").sorted() }
        .sortedBy { it.size }

    return calcDiff(list, 0, intArrayOf(list[0][0].toInt()))
}

fun calcDiff(list: List<List<String>>, index: Int, acc: IntArray): IntArray {
    if (index == list.size - 1)
        return acc
    for (i in list[index].indices) {
        if (list[index][i] != list[index + 1][i])
            return calcDiff(list, index + 1, acc + list[index + 1][i].toInt())
    }
    return calcDiff(list, index + 1, acc + list[index + 1].last().toInt())
}

fun main() {
    println(solution_("{{2},{2,1},{2,1,3},{2,1,3,4}}").contentToString())
}