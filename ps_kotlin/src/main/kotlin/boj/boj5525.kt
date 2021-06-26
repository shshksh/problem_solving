package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val str = br.readLine()

    var count = 0
    var prev = 'I'
    var result = 0
    var flag = false
    for (c in str) {
        if (c == 'I') {
            if (flag && prev == 'O')
                count++
            else
                count = 0
            if (count >= n)
                result++
            flag = true
        } else {
            if (prev == 'O') {
                count = 0
                flag = false
            }
        }
        prev = c
    }

    println(result)
}