fun main() {
    val n = readLine()!!.toInt()

    println(dsc(n))
}

private fun dsc(n: Int): String {
    if (n < 12)
        return (n - 1).toString()
    if (n > 1023)
        return "-1"

    val prev = dsc(n - 1)
    var curr = prev.slice(0 until prev.lastIndex) + (prev.last() + 1)
    if (isDescending(curr))
        return curr
    curr = nextDescending(curr)
    return curr
}

private fun nextDescending(curr: String): String {
    val arr = curr.toCharArray()
    for (i in curr.lastIndex downTo 1) {
        if (arr[i] == arr[i - 1]) {
            arr[i] = if (i == curr.lastIndex) '0' else arr[i + 1] + 1
            arr[i - 1] = arr[i - 1] + 1
        }
    }
    return if (arr[0] > '9')
        ('0' + arr.size downTo '0').joinToString("")
    else
        arr.joinToString("")
}

private fun isDescending(num: String): Boolean {
    for (i in num.lastIndex - 1 downTo 0)
        if (num[i] <= num[i + 1])
            return false
    return true
}
