package skill_checks.level3

fun solution(tickets: Array<Array<String>>): Array<String> {

    fun dfs(acc: Array<String>, next: String, list: List<Array<String>>): Array<String> {
        if (acc.size == tickets.size) {
            return acc + next
        }
        for ((i, ticket) in list.withIndex()) {
            if (next == ticket[0]) {
                val result = dfs(acc + next,
                    ticket[1],
                    list.slice(0 until i) + list.slice(i + 1 until list.size))
                if (result.isNotEmpty())
                    return result
            }
        }
        return arrayOf()
    }

    val ticketList = tickets.sortedWith(Comparator { o1, o2 ->
        if (o1[0] == o2[0])
            o1[1].compareTo(o2[1])
        else
            o1[0].compareTo(o2[0])
    })

    for ((i, ticket) in ticketList.withIndex()) {
        if (ticket[0] == "ICN") {
            val result = dfs(arrayOf(ticket[0]),
                ticket[1],
                ticketList.slice(0 until i) + ticketList.slice(i + 1 until ticketList.size))
            if (result.size == tickets.size + 1)
                return result
        }
    }

    return arrayOf()
}

fun main() {
    println(
        solution(arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL", "SFO"),
    )).contentToString())

    println(
        solution(arrayOf(
        arrayOf("ICN", "JFK"),
        arrayOf("HND", "IAD"),
        arrayOf("JFK", "HND"),
    )).contentToString())

    println(
        solution(arrayOf(
        arrayOf("ICN", "A"),
        arrayOf("ICN", "A"),
        arrayOf("A", "ICN"),
        arrayOf("A", "C")
    )).contentToString())

    println(
        solution(arrayOf(
        arrayOf("ICN", "B"),
        arrayOf("B", "ICN"),
        arrayOf("ICN", "A"),
        arrayOf("A", "D"),
        arrayOf("D", "A")
    )).contentToString())
}
