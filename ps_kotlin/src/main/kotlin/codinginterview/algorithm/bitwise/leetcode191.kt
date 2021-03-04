package codinginterview.algorithm.bitwise

fun hammingWeight(n:Int):Int {
    var count = 0
    var mask = 1
    for (i in 0..31) {
        if (n and mask != 0)
            count++
        mask = mask shl 1
    }
    return count
}