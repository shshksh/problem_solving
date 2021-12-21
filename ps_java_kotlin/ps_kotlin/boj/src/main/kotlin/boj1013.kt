import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val testCase = br.readLine().toInt()

    for (i in 1..testCase) {
        val sign = br.readLine()

        if (isMatch(sign, 0))
            sb.append("YES").appendLine()
        else
            sb.append("NO").appendLine()
    }
    print(sb.toString())
}

fun isMatch(sign: String, start: Int, prev: String = ""): Boolean {
    if (start == sign.length) {
        if (prev.isEmpty() || prev == "1")
            return true
        return false
    }

    if ((prev.isEmpty() || prev == "1") && sign.startsWith("01", start))
        return isMatch(sign, start + 2)
    else if ((prev.isEmpty() || prev == "1") && sign.startsWith("10", start))
        return isMatch(sign, start + 2, "10") || prev == "1" && isMatch(sign, start + 1, "1")
    else if ((prev == "10" || prev == "0") && sign.startsWith("0", start))
        return isMatch(sign, start + 1, "0")
    else if ((prev == "0" || prev == "1") && sign.startsWith("1", start))
        return isMatch(sign, start + 1, "1")
    else if (prev == "1" && sign.startsWith("0", start))
        return isMatch(sign, start)
    return false
}
