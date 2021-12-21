import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val st1 = StringTokenizer(br.readLine(), " ")
    val cards = IntArray(20_000_001)
    repeat(n) { cards[st1.nextToken().toInt() + 10_000_000]++ }

    val m = br.readLine().toInt()
    val st2 = StringTokenizer(br.readLine(), " ")
    repeat(m) {
        bw.write("${cards[st2.nextToken().toInt() + 10_000_000]} ")
    }
    bw.flush()
}
