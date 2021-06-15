package boj

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()

    repeat(n) {
        if (isValidParen(br.readLine())) bw.write("YES\n") else bw.write("NO\n")
    }
    bw.flush()
}

fun isValidParen(parens: String): Boolean {
    val st = Stack<Char>()
    for (paren in parens) {
        if (paren == '(') {
            st.push(paren)
        } else if (paren == ')') {
            if (st.isEmpty())
                return false
            st.pop()
        }
    }
    return st.isEmpty()
}
