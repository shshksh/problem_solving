package programmers.kakao

fun solution(new_id: String): String {

    return new_id.toLowerCase()
        .filter { it in 'a'..'z' || it in '0'..'9' || it in "-_." }
        .fold("") { acc, c -> if (acc.isNotEmpty() && acc.last() == '.' && c == '.') acc else acc + c }
        .dropWhile { it == '.' }
        .dropLastWhile { it == '.' }
        .let { if (it.isEmpty()) "a" else it }
        .take(15)
        .dropLastWhile { it == '.' }
        .let { if (it.length == 1) it + it + it else if (it.length == 2) it + it.last() else it }
}

fun main() {
    println(solution("...!@BaT#*..y.abcdefghijklm"))
}