import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val st = Stack<Int>()
    var target = br.readLine().toInt()
    var readCount = 1

    for (i in 1..n) {
        st.push(i)
        sb.append("+\n")

        while (st.isNotEmpty() && st.peek() == target) {
            st.pop()
            if (readCount < n) {
                target = br.readLine().toInt()
                readCount++
            }
            sb.append("-\n")
        }

        if (st.isNotEmpty() && st.peek() > target) {
            break
        }
    }
    if (st.isEmpty()) print(sb.toString()) else println("NO")
}
