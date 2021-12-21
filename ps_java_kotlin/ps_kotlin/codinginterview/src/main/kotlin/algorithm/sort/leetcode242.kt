package algorithm.sort

fun isAnagram(s: String, t: String): Boolean {
    val charCount1 = IntArray(26)
    val charCount2 = IntArray(26)
    for (c in s) {
        charCount1[c.code - 97]++
    }
    for (c in t) {
        charCount2[c.code - 97]++
    }

    return charCount1.contentEquals(charCount2)
}
