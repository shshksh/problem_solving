import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val stars = Array(n) {
        val st = StringTokenizer(br.readLine(), " ")
        DoubleArray(2) { st.nextToken().toDouble() }
    }
    val edges = Array(n) { mutableListOf<Pair<Int, Double>>() }

    for (i in stars.indices) {
        for (j in i + 1..stars.lastIndex) {
            val distance = distanceOf(stars[i], stars[j])
            edges[i].add(j to distance)
            edges[j].add(i to distance)
        }
    }

    var mst = 0.0
    val check = BooleanArray(n)
    val q = PriorityQueue<Pair<Int, Double>>(compareBy { it.second })
    q.offer(0 to 0.0)

    while (q.isNotEmpty()) {
        val edge = q.poll() ?: continue
        if (check[edge.first]) continue

        check[edge.first] = true
        mst += edge.second

        for (adj in edges[edge.first]) {
            if (!check[adj.first]) {
                q.offer(adj)
            }
        }
    }

    println("%.2f".format(mst))
}

private fun distanceOf(star1: DoubleArray, star2: DoubleArray) =
    sqrt((star1[0] - star2[0]).pow(2) + (star1[1] - star2[1]).pow(2))
