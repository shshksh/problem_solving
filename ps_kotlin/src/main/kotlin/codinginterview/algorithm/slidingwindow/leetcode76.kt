package codinginterview.algorithm.slidingwindow

fun minWindow(s: String, t: String): String {
    val targetCounter = mutableMapOf<Char, Int>()
    val windowCounter = mutableMapOf<Char, Int>()

    for (c in t) {
        targetCounter[c] = targetCounter.getOrDefault(c, 0) + 1
    }

    var (head, tail) = 0 to 0

    while (tail < s.length) {
        windowCounter[s[tail]] = windowCounter.getOrDefault(s[tail], 0) + 1

        if (isMatch(windowCounter, targetCounter))
            break

        tail++
    }

    if (tail >= s.length)
        return ""

    var result = ""

    while (head <= tail && head < s.length && tail < s.length) {
        if (isMatch(windowCounter, targetCounter)) {
            result = s.slice(head..tail)
            windowCounter[s[head]] = windowCounter[s[head]]!! - 1
            head++
        } else {
            windowCounter[s[head]] = windowCounter[s[head]]!! - 1
            head++
            tail++

            if (tail >= s.length)
                break

            windowCounter[s[tail]] = windowCounter.getOrDefault(s[tail], 0) + 1
        }
    }

    return result
}

fun isMatch(
    windowCounter: MutableMap<Char, Int>,
    targetCounter: MutableMap<Char, Int>
): Boolean {
    for (key in targetCounter.keys) {
        if (!windowCounter.containsKey(key) || windowCounter[key]!! < targetCounter[key]!!)
            return false
    }
    return true
}

fun main() {
//    println(minWindow("ADOBECODEBANC", "ABC"))
//    println(minWindow("a", "a"))
    println(minWindow("ab", "a"))
}