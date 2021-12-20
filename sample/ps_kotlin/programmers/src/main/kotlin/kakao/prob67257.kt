package kakao

import java.util.*

fun solution67257(expression: String): Long {
    var max = 0L

    max = maxOf(max, calcAll("+-*", expression))
    max = maxOf(max, calcAll("+*-", expression))
    max = maxOf(max, calcAll("-+*", expression))
    max = maxOf(max, calcAll("-*+", expression))
    max = maxOf(max, calcAll("*+-", expression))
    max = maxOf(max, calcAll("*-+", expression))

    return max
}

fun calcAll(priority: String, expression: String): Long {
    val operands = ArrayDeque<Long>()
    val operators = ArrayDeque<Char>()

    var start = 0
    for ((i, c) in expression.withIndex()) {
        if (c in priority) {
            operands.addLast(expression.slice(start until i).toLong())
            operators.addLast(c)
            start = i + 1
        }
    }
    operands.addLast(expression.slice(start until expression.length).toLong())

    val result = calc(priority, operands, operators)
    return if (result < 0) result * -1 else result
}

fun calc(
    priority: String,
    operands: ArrayDeque<Long>,
    operators: ArrayDeque<Char>
): Long {
    for (p in priority) {
        val size = operators.size

        for (i in 1..size) {
            var lvalue = operands.removeFirst()
            val op = operators.removeFirst()
            if (op == p) {
                when (op) {
                    '+' -> operands.addFirst(lvalue + operands.removeFirst())
                    '-' -> operands.addFirst(lvalue - operands.removeFirst())
                    '*' -> operands.addFirst(lvalue * operands.removeFirst())
                }
            } else {
                operands.addLast(lvalue)
                operators.addLast(op)
            }
        }
        operands.addLast(operands.removeFirst())
    }

    return operands.removeFirst()
}
