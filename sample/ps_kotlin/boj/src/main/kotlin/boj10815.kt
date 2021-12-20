import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val cards = IntArray(500000)
    val st = StringTokenizer(br.readLine(), " ")

    for (i in 0 until n) {
        cards[i] = st.nextToken().toInt()
    }
    cards.sort()

    val m = br.readLine().toInt()
    val st2 = StringTokenizer(br.readLine(), " ")

    while (st2.hasMoreTokens()) {
        if (cards.binarySearch(st2.nextToken().toInt()) >= 0)
            bw.write("1 ")
        else
            bw.write("0 ")
    }
    bw.flush()
}
