package nonlinear.trie

fun palindromePairs(words: Array<String>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    words.map { s -> words.map { s + it } }
        .forEachIndexed { i, list ->
            list.forEachIndexed { j, s ->
                if (i != j && s.isPalindrome())
                    result.add(listOf(i, j))
            }
        }
    return result
}

fun String.isPalindrome() = this == this.reversed()

fun main() {
    println(palindromePairs(arrayOf("bat", "tab", "cat")))
}
