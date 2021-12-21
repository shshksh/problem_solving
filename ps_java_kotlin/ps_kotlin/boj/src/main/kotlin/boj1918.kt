fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val expression = br.readLine()
    val highOp = charArrayOf('*', '/')
    val lowOp = charArrayOf('+', '-')

    val stack = ArrayDeque<Char>()

    for (c in expression) {
        if (c in 'A'..'Z') {
            bw.write(c.code)
            if (stack.isNotEmpty() && stack.last() in highOp) {
                bw.write(stack.removeLast().code)
            }
        } else if (c in highOp || c in lowOp) {
            if (stack.isEmpty() || stack.last() == '(') {
                stack.addLast(c)
            } else if (stack.last() in lowOp && c in lowOp) {
                bw.write(stack.removeLast().code)
                stack.addLast(c)
            } else if (stack.last() in highOp && c in highOp) {
                bw.write(stack.removeLast().code)
                stack.addLast(c)
            } else if (stack.last() in lowOp && c in highOp) {
                stack.addLast(c)
            }
        } else if (c == '(') {
            stack.addLast(c)
        } else if (c == ')') {
            while (stack.last() != '(') {
                bw.write(stack.removeLast().code)
            }
            stack.removeLast()
        }
    }
    while (stack.isNotEmpty()) {
        bw.write(stack.removeLast().code)
    }

    bw.flush()
}
