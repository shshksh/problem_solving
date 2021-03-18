package programmers.skill_checks.level2

fun solution(p: String): String {
    if (p.isEmpty())
        return ""

    val position = partition(p)
    if (p.startsWith("(") && position == p.length)
        return p

    val left = p.slice(0 until position)
    val right = p.slice(position until p.length)

    if (left.startsWith("("))
        return left + solution(right)

    val prefix = "(" + solution(right) + ")"
    return prefix + reverse(left.slice(1 until left.length - 1))
}

fun reverse(slice: String): String {
    val arr = CharArray(slice.length)
    for (i in arr.indices) {
        arr[i] = if (slice[i] == '(') ')' else '('
    }
    return arr.joinToString(separator = "")
}

fun partition(p: String): Int {
    var checker = 0
    for ((i, c) in p.withIndex()) {
        if (c == '(')
            checker++
        else
            checker--
        if (checker == 0)
            return i + 1
    }
    return -1
}

fun main() {
    println(solution("()"))
    println(solution(")("))
    println(solution("(()())()"))
    println(solution("()))((()"))
}