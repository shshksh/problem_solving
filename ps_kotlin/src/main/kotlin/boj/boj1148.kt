package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val words = mutableListOf<IntArray>()
    while (true) {
        val word = br.readLine()
        if (word == "-")
            break
        val freq = IntArray(26)
        for (c in word) {
            freq[c.toInt() - 65]++
        }
        words.add(freq)
    }

    while (true) {
        val board = br.readLine()
        if (board == "#")
            break
        val mask = IntArray(26)
        for (c in board.toCharArray()) {
            mask[c.toInt() - 65]++
        }

        val result = IntArray(26)
        for (word in words) {
            if (isValid(word, mask)) {
                for ((i, v) in word.withIndex()) {
                    if (v > 0)
                        result[i]++
                }
            }
        }
        var max = 0
        var min = Int.MAX_VALUE
        for (i in 0..25) {
            if (mask[i] > 0) {
                max = maxOf(max, result[i])
                min = minOf(min, result[i])
            }
        }
        for (i in 0..25) {
            if (mask[i] > 0 && result[i] == min) {
                bw.write("${(i + 65).toChar()}")
            }
        }
        bw.write(" $min ")
        for (i in 0..25) {
            if (mask[i] > 0 && result[i] == max) {
                bw.write("${(i + 65).toChar()}")
            }
        }
        bw.write(" $max\n")
    }
    bw.flush()
}

private fun isValid(word: IntArray, mask: IntArray): Boolean {
    for (i in 0..25) {
        if (word[i] > mask[i])
            return false
    }
    return true
}