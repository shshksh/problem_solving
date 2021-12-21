import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val graph = Array(n) {
        val st = StringTokenizer(br.readLine())
        IntArray(n) {
            val token = st.nextToken().toInt()
            if (token == 0) 100000000 else token
        }
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    for (row in graph) {
        for (col in row) {
            if (col == 100000000) bw.write("0 ")
            else (bw.write("1 "))
        }
        bw.newLine()
    }
    bw.flush()
}
