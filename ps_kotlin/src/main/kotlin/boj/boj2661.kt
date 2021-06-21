package boj

fun main() {
    val n = readLine()!!.toInt()

    fun isBadSequence(seq: String): Boolean {
        for (i in 1..seq.length / 2) {
            if (seq.substring(seq.length - i)
                == seq.substring(seq.length - i - i, seq.length - i))
                return true
        }
        return false
    }

    fun dfs(seq: String): String {
        if (isBadSequence(seq))
            return ""
        if (seq.length == n)
            return seq
        for (i in 1..3) {
            val result = dfs(seq + i)
            if (result.length == n)
                return result
        }
        return ""
    }

    println(dfs(""))
}