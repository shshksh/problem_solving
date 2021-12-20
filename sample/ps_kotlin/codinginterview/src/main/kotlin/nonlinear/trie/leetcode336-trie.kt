package nonlinear.trie

class TrieNode(
    var children: MutableMap<Char, TrieNode> = mutableMapOf(),
    var id: Int = -1,
    var palindromeWordIds: MutableList<Int> = mutableListOf()
)

class Trie() {
    var root = TrieNode()

    fun insert(index: Int, word: String) {
        var node = root
        word.reversed().forEachIndexed { i, c ->
            if (isPalindrome(word.slice(0 until word.length - i)))
                node.palindromeWordIds.add(index)
            node = node.children.getOrPut(c, { TrieNode() })
        }
        node.id = index
    }

    private fun isPalindrome(word: String) = word == word.reversed()

    fun search(index: Int, word: String): MutableList<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var node = root

        var w = word
        while (w.isNotEmpty()) {
            if (node.id >= 0) {
                if (isPalindrome(w)) {
                    result.add(listOf(index, node.id))
                }
            }
            if (!node.children.containsKey(w[0]))
                return result
            node = node.children[w[0]]!!
            w = w.slice(1 until w.length)
        }

        if (node.id >= 0 && node.id != index) {
            result.add(listOf(index, node.id))
        }

        for (palindromeWordId in node.palindromeWordIds) {
            result.add(listOf(index, palindromeWordId))
        }

        return result
    }
}

//class Solution {
//    fun palindromePairs(words: Array<String>): List<List<Int>> {
//        val trie = Trie()
//        words.forEachIndexed { index, s ->
//            trie.insert(index, s)
//        }
//
//        val result = mutableListOf<List<Int>>()
//        words.forEachIndexed { index, s ->
//            result.addAll(trie.search(index, s))
//        }
//
//        return result
//    }
//}

//fun main() {
//    println(
//        Solution().palindromePairs(
//            arrayOf(
//                "d",
//                "cbbcd",
//                "dcbb",
//                "dcbc",
//                "cbbc",
//                "bbcd"
//            )
//        )
//    )
//}
