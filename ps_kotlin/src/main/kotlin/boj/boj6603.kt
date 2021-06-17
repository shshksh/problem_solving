package boj

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {

    while (true) {
        val nums = br.readLine().split(" ")

        if (nums[0] == "0") break

        printCombOf(nums.slice(1 until nums.size), nums[0].toInt(), listOf())
        bw.newLine()
    }
    bw.flush()
}

fun printCombOf(list: List<String>, k: Int, acc: List<String>) {
    if (acc.size == 6) {
        bw.write(acc.joinToString(" ") + "\n")
        return
    }
    if (list.size + acc.size < 6)
        return

    for (i in list.indices) {
        printCombOf(list.slice(i + 1 until list.size), k, acc + list[i])
    }
}
