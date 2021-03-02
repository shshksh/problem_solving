package codinginterview.algorithm.bitwise

fun hammingDistance(x: Int, y: Int): Int {
    val result: Long = (x xor y).toLong()
    var mask: Long = 1
    var count = 0
    while (mask <= result) {
        if (mask and result > 0)
            count++
        mask = mask shl 1
    }
    return count
}