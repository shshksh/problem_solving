fun main() {
    val n = readLine()!!.toInt()
    val dice = readLine()!!.split(" ").map { it.toInt() }
    if (n == 1) {
        println(dice.sum() - dice.maxOf { it })
        return
    }
    val index = dice.indexOf(dice.minOf { it })
    val arr = IntArray(3)
    arr[0] = dice[index]

    var max = 101
    val side = (0..5).filter { it != index && it != 5 - index }
    for (i in 0..2) {
        for (j in i + 1..3) {
            if (side[i] + side[j] == 5)
                continue
            if (dice[side[i]] + dice[side[j]] < max) {
                max = dice[side[i]] + dice[side[j]]
                if (dice[side[i]] < dice[side[j]]) {
                    arr[1] = dice[side[i]]
                    arr[2] = dice[side[j]]
                } else {
                    arr[2] = dice[side[i]]
                    arr[1] = dice[side[j]]
                }
            }
        }
    }

    val vertex = 4L
    val edge = 8L * n - 8
    val remain = 5L * n * n - vertex - edge

    println(arr[2] * vertex + arr[1] * edge + arr[0] * remain)
}
