package algorithm.bitwise

fun getSum(a: Int, b: Int): Int {
    var carry = false
    var (bit1, bit2) = false to false

    var mask = 1
    var result = 0

    for (i in 0 until 32) {
        bit1 = a and mask != 0
        bit2 = b and mask != 0

        if (bit1 xor bit2 xor carry)
            result = result or mask

        carry = (bit1 and bit2) or (bit1 and carry) or (bit2 and carry)
        mask = mask shl 1
    }

    return result
}
