package codinginterview.algorithm.bitwise

fun validUtf8(data: IntArray): Boolean {

    var index = 0
    while (index < data.size) {
        val charSize = sizeOf(data[index])
        if (charSize < 0 || charSize > 4)
            return false

        if (charSize > 1) {
            var count = 1
            for (i in (index + 1)until index + charSize) {
                if (i >= data.size || data[i] ushr 6 != 0b10)
                    return false
                count++
            }
            index += count
        } else {
            index++
        }
    }

    return true
}

fun sizeOf(c: Int): Int {
    if (c and 0b1000_0000 == 0)
        return 1

    if (c ushr 6 == 0b10)
        return -1

    var mask = 0b1000_0000
    var count = 0
    while (c and mask != 0) {
        mask = mask ushr 1
        count++
    }
    return count
}
