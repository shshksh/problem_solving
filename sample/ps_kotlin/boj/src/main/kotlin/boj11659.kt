import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(br.readLine())
    val arr = IntArray(n + 1)
    for (index in 1 until arr.size) {
        arr[index] = st.nextToken().toInt()
        arr[index] += arr[index - 1]
    }
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${arr[j] - arr[i - 1]}\n")
    }
    bw.flush()
}
