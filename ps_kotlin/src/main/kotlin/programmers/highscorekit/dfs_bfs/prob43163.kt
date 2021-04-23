package programmers.highscorekit.dfs_bfs

import java.util.*

fun solution(begin: String, target: String, words: Array<String>): Int {
    if (target !in words)
        return 0

    val q = LinkedList<String>()
    q.offer(begin)
    var answer = 0

    var remainWords = words.toList()

    while (q.isNotEmpty()) {
        val adjSize = q.size
        answer++

        for (i in 0 until adjSize) {
            val currString = q.poll()

            remainWords.forEach {
                if (isSimilar(currString, it)) {
                    if (it == target)
                        return answer

                    remainWords = remainWords - it
                    q.offer(it)
                }
            }
        }
    }

    return 0
}

fun isSimilar(currString: String?, it: String): Boolean {
    if (currString == null)
        return false
    var result = true
    for (i in currString.indices) {
        if (currString[i] != it[i]) {
            if (result)
                result = false
            else
                return false
        }
    }
    return true
}

fun main() {
    println(solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")))
    println(solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log")))
    println(solution("hit", "cuc", arrayOf("hot", "cit", "cut", "hog", "log", "lug", "luc", "cuc")))
}
