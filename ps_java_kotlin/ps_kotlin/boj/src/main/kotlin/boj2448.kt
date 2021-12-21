fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val length = (n / 3 * 5) + (n / 3 - 1)

    val line = CharArray(length) { ' ' }
    line[length / 2] = '*'
    bw.write(line)
    bw.newLine()

    while (line[0] != '*') {
        if (isCapstone(line))
            makeMiddle(line)
        else if (isMiddle(line))
            makeFloor(line)
        else if (isFloor(line))
            makeCapstone(line)
        bw.write(line)
        bw.newLine()
    }
    bw.flush()
}

fun isCapstone(line: CharArray): Boolean {
    val start = line.indexOf('*')
    if (line[start + 1] == ' ' && line[start + 2] == ' ')
        return true
    return false
}

fun makeMiddle(line: CharArray) {
    var i = 0
    while (i < line.size) {
        if (line[i] == '*') {
            line[i] = ' '
            line[i - 1] = '*'
            line[i + 1] = '*'
            i++
        }
        i++
    }
}

fun isMiddle(line: CharArray): Boolean {
    val start = line.indexOf('*')
    if (line[start + 1] == ' ' && line[start + 2] == '*')
        return true
    return false
}

fun makeFloor(line: CharArray) {
    var i = 0
    while (i < line.size) {
        if (line[i] == '*') {
            line.fill('*', i - 1, i + 2)
            i++
        }
        i++
    }
}

fun isFloor(line: CharArray): Boolean {
    val start = line.indexOf('*')
    if (line[start + 1] == '*' && line[start + 2] == '*')
        return true
    return false
}

fun makeCapstone(line: CharArray) {
    var i = 0
    while (i < line.size) {
        if (line[i] == '*') {
            line[i - 1] = '*'
            while (line[i] == '*') {
                line.fill(' ', i, i + 5)
                i += 6
            }
            line[i - 1] = '*'
        }
        i++
    }
}
