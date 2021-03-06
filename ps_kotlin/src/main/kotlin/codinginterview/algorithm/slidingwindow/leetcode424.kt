package codinginterview.algorithm.slidingwindow

fun characterReplacement(s: String, k: Int): Int {
    var head = 0
    val counter = mutableMapOf<Char, Int>()

    for (tail in s.indices) {
        counter[s[tail]] = counter.getOrDefault(s[tail], 0) + 1
        val mCount = counter.values.max() ?: 0

        if (tail - head - mCount >= k) {
             counter[s[head]] = counter.getOrDefault(s[head], 0) - 1
            head++
        }
    }

    return s.length - head
}

fun main() {
    println(characterReplacement("AABABBA", 1))
}