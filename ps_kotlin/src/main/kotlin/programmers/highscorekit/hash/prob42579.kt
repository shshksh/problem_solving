package programmers.highscorekit.hash

fun solution(genres: Array<String>, plays: IntArray): IntArray {
    return genres.mapIndexed { index, s -> s to index }
        .groupBy({ it.first }, { it.second to plays[it.second] })
        .values
        .sortedByDescending { it.sumBy { pair -> pair.second } }
        .flatMap { it.sortedByDescending { pair -> pair.second }.take(2) }
        .map { it.first }
        .toIntArray()
}

fun main() {
    solution(arrayOf("classic", "pop", "classic", "classic", "pop", "k"),
        intArrayOf(500, 600, 150, 800, 2500, 100))
}