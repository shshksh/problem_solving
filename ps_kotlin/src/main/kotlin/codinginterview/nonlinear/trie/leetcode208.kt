package codinginterview.nonlinear.trie

//class Trie() {
//
//    /** Initialize your data structure here. */
//    private var value: Char? = null
//    private val children = mutableSetOf<Trie?>()
//
//    constructor(c: Char) : this() {
//        this.value = c
//    }
//
//    /** Inserts a word into the trie. */
//    fun insert(word: String) {
//        var curr = this
//        for (c in word) {
//            var next = getChild(curr.children, c)
//            if (next == null) {
//                next = Trie(c)
//                curr.children.add(next)
//            }
//            curr = next
//        }
//        curr.children.add(null)
//    }
//
//    private fun getChild(curr: MutableSet<Trie?>, c: Char): Trie? {
//        for (trie in curr)
//            if (trie?.value == c)
//                return trie
//        return null
//    }
//
//    /** Returns if the word is in the trie. */
//    fun search(word: String): Boolean {
//        var curr = this
//        for (c in word) {
//            val next = getChild(curr.children, c)
//            next ?: return false
//            curr = next
//        }
//        return null in curr.children
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    fun startsWith(prefix: String): Boolean {
//        var curr = this
//        for (c in prefix) {
//            val next = getChild(curr.children, c)
//            next ?: return false
//            curr = next
//        }
//        return true
//    }
//
//}