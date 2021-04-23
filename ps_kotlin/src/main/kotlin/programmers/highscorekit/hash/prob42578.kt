package programmers.highscorekit.hash

fun solution(clothes: Array<Array<String>>): Int {
    return clothes.groupBy({ it[1] }, { it[0] })
        .values
        .map { it.size + 1 }
        .reduce { acc, i -> acc * i } - 1
}