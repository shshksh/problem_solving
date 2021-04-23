package programmers.highscorekit.dfs_bfs

fun solution(tickets: Array<Array<String>>): Array<String> {

    fun dfs(
        curr: String, remain: List<Array<String>>, visit: Array<String>
    ): Array<String> {
        if (remain.isEmpty())
            return visit

        for ((i, ticket) in remain.withIndex()) {
            if (curr == ticket[0]) {
                val result = dfs(ticket[1],
                    remain.filterIndexed { index, _ -> i != index },
                    visit + ticket[1])
                if (result.isNotEmpty())
                    return result
            }
        }
        return arrayOf()
    }

    return dfs("ICN", tickets.sortedBy { it[0] + it[1] }, arrayOf("ICN"))
}

fun main() {
    println(solution(arrayOf(
        arrayOf("ICN", "JFK"),
        arrayOf("HND", "IAD"),
        arrayOf("JFK", "HND")
    )).contentToString())

    println(solution(arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL", "SFO")
    )).contentToString())

    println(solution(arrayOf(
        arrayOf("ICN", "ATL")
    )).contentToString())
}