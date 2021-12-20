package nonlinear.graph

fun findItinerary(tickets: List<List<String>>): List<String> {
    val ticketMap = mutableMapOf<String, MutableList<String>>()
    for (ticket in tickets.sortedBy { list: List<String> -> list[0] + list[1] }) {
        ticketMap.getOrPut(ticket[0]) { mutableListOf() }.add(ticket[1])
    }

    fun dfs(
        path: MutableList<String>,
        next: String
    ): List<String> {
        if (path.size == tickets.size) {
            return path
        }

        val nextTickets = ticketMap[next] ?: mutableListOf()
        nextTickets.distinct().forEach {
            nextTickets.remove(it)
            val result = dfs((path + it) as MutableList<String>, it)
            if (result.size == tickets.size)
                return result
            nextTickets.add(it)
        }
        return listOf()
    }

    return listOf("JFK") + dfs(mutableListOf(), "JFK")
}

fun main() {
    println(
        findItinerary(
            listOf(
                listOf("AXA", "EZE"),
                listOf("EZE", "AUA"),
                listOf("ADL", "JFK"),
                listOf("ADL", "TIA"),
                listOf("AUA", "AXA"),
                listOf("EZE", "TIA"),
                listOf("EZE", "TIA"),
                listOf("AXA", "EZE"),
                listOf("EZE", "ADL"),
                listOf("ANU", "EZE"),
                listOf("TIA", "EZE"),
                listOf("JFK", "ADL"),
                listOf("AUA", "JFK"),
                listOf("JFK", "EZE"),
                listOf("EZE", "ANU"),
                listOf("ADL", "AUA"),
                listOf("ANU", "AXA"),
                listOf("AXA", "ADL"),
                listOf("AUA", "JFK"),
                listOf("EZE", "ADL"),
                listOf("ANU", "TIA"),
                listOf("AUA", "JFK"),
                listOf("TIA", "JFK"),
                listOf("EZE", "AUA"),
                listOf("AXA", "EZE"),
                listOf("AUA", "ANU"),
                listOf("ADL", "AXA"),
                listOf("EZE", "ADL"),
                listOf("AUA", "ANU"),
                listOf("AXA", "EZE"),
                listOf("TIA", "AUA"),
                listOf("AXA", "EZE"),
                listOf("AUA", "SYD"),
                listOf("ADL", "JFK"),
                listOf("EZE", "AUA"),
                listOf("ADL", "ANU"),
                listOf("AUA", "TIA"),
                listOf("ADL", "EZE"),
                listOf("TIA", "JFK"),
                listOf("AXA", "ANU"),
                listOf("JFK", "AXA"),
                listOf("JFK", "ADL"),
                listOf("ADL", "EZE"),
                listOf("AXA", "TIA"),
                listOf("JFK", "AUA"),
                listOf("ADL", "EZE"),
                listOf("JFK", "ADL"),
                listOf("ADL", "AXA"),
                listOf("TIA", "AUA"),
                listOf("AXA", "JFK"),
                listOf("ADL", "AUA"),
                listOf("TIA", "JFK"),
                listOf("JFK", "ADL"),
                listOf("JFK", "ADL"),
                listOf("ANU", "AXA"),
                listOf("TIA", "AXA"),
                listOf("EZE", "JFK"),
                listOf("EZE", "AXA"),
                listOf("ADL", "TIA"),
                listOf("JFK", "AUA"),
                listOf("TIA", "EZE"),
                listOf("EZE", "ADL"),
                listOf("JFK", "ANU"),
                listOf("TIA", "AUA"),
                listOf("EZE", "ADL"),
                listOf("ADL", "JFK"),
                listOf("ANU", "AXA"),
                listOf("AUA", "AXA"),
                listOf("ANU", "EZE"),
                listOf("ADL", "AXA"),
                listOf("ANU", "AXA"),
                listOf("TIA", "ADL"),
                listOf("JFK", "ADL"),
                listOf("JFK", "TIA"),
                listOf("AUA", "ADL"),
                listOf("AUA", "TIA"),
                listOf("TIA", "JFK"),
                listOf("EZE", "JFK"),
                listOf("AUA", "ADL"),
                listOf("ADL", "AUA"),
                listOf("EZE", "ANU"),
                listOf("ADL", "ANU"),
                listOf("AUA", "AXA"),
                listOf("AXA", "TIA"),
                listOf("AXA", "TIA"),
                listOf("ADL", "AXA"),
                listOf("EZE", "AXA"),
                listOf("AXA", "JFK"),
                listOf("JFK", "AUA"),
                listOf("ANU", "ADL"),
                listOf("AXA", "TIA"),
                listOf("ANU", "AUA"),
                listOf("JFK", "EZE"),
                listOf("AXA", "ADL"),
                listOf("TIA", "EZE"),
                listOf("JFK", "AXA"),
                listOf("AXA", "ADL"),
                listOf("EZE", "AUA"),
                listOf("AXA", "ANU"),
                listOf("ADL", "EZE"),
                listOf("AUA", "EZE")
            )
        )
    )
}
