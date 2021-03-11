package codinginterview.algorithm.divideandconquer

// 접근
//fun diffWaysToCompute(input: String): List<Int> {
//    val resultSet = mutableSetOf<String>()
//    fun dfs(list: List<String>) {
//        if (list.size == 2) {
//            val result = "(" + list[0] + list[1] + ")"
//            if (!resultSet.contains(result)) {
//                resultSet.add(result)
//                println(result)
//            }
//        } else {
//            var i = 0
//            while (i < list.size - 1) {
//                val sum = "(" + list[i] + list[i + 1] + ")"
//                when {
//                    i < 1 -> dfs(listOf(sum) + list.slice(i + 2 until list.size))
//                    i < list.size - 2 -> dfs((list.slice(0 until i) + sum + list.slice(i + 2 until list.size)))
//                    else -> dfs(list.slice(0 until i) + sum)
//                }
//                i++
//            }
//        }
//    }
//    dfs(listOf("a", "b", "c", "d"))
//    println(resultSet.size)
//    return listOf()
//}

// 솔루션
fun diffWaysToCompute(input: String): List<Int> {
    input.toIntOrNull()?.let {
        return listOf(input.toInt())
    }

    val result = mutableListOf<Int>()
    for ((i, c) in input.withIndex()) {
        if (c in "+-*") {
            val left = diffWaysToCompute(input.slice(0 until i))
            val right = diffWaysToCompute(input.slice(i + 1 until input.length))

            result.addAll(calc(left, right, c))
        }
    }

    return result
}

fun calc(left: List<Int>, right: List<Int>, op: Char): List<Int> {
    val result = mutableListOf<Int>()
    for (i in left) {
        for (j in right) {
            when (op) {
                '+' -> result.add(i + j)
                '-' -> result.add(i - j)
                '*' -> result.add(i*j)
            }
        }
    }
    return result
}

fun main() {
    println(diffWaysToCompute("2*3-4*5"))
}