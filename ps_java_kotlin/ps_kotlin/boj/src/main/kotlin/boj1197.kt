import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (v, e) = br.readLine().split(" ").map { it.toInt() }

    val check = BooleanArray(v + 1)
    var n = 0
    val graph = Array(v + 1) { mutableListOf<Pair<Int, Int>>() }

    for (i in 1..e) {
        val st = StringTokenizer(br.readLine(), " ")
        val (from, to, weight) = intArrayOf(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())

        graph[from].add(to to weight)
        graph[to].add(from to weight)
    }

    val q = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }
    q.offer(1 to 0)

    var weightSum = 0

    while (n < v) {
        val node = q.poll() ?: continue
        if (check[node.first]) continue

        check[node.first] = true
        weightSum += node.second

        for (pair in graph[node.first]) {
            if (!check[pair.first]) {
                q.offer(pair)
            }
        }

        n++
    }

    println(weightSum)
}
