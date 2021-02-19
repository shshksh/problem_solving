package codinginterview.algorithm.sort

fun isAnagram(s: String, t: String): Boolean {
    val charCount1 = IntArray(26)
    val charCount2 = IntArray(26)
    for (c in s) {
        charCount1[c.toInt() - 97]++
    }
    for (c in t) {
        charCount2[c.toInt() - 97]++
    }

    return charCount1.contentEquals(charCount2)
}