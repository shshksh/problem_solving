package nonlinear.graph

fun letterCombinations(digits: String): List<String> {
    val cMap = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    return if (digits.isEmpty()) listOf() else printAllCombinations(cMap, digits)
}

fun printAllCombinations(cMap: Map<Char, String>, digits: String): MutableList<String> {

    if (digits.isEmpty()) {
        return mutableListOf("")
    }
    val subList = printAllCombinations(cMap, digits.substring(1))
    val result = mutableListOf<String>()

    for (c in cMap[digits[0]]!!) {
        result += subList.map { "$c" + it }
    }

    return result
}

fun main() {
    letterCombinations("23").forEach(::println)
}
