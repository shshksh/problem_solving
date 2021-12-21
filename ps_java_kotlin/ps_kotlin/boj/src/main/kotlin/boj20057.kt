import java.util.*

private const val LEFT = 0
private const val BOTTOM = 1
private const val RIGHT = 2
private const val TOP = 3

private val percents = arrayOf(
    arrayOf(
        doubleArrayOf(0.0, 0.0, 0.02, 0.0, 0.0),
        doubleArrayOf(0.0, 0.10, 0.07, 0.01, 0.0),
        doubleArrayOf(0.05, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.10, 0.07, 0.01, 0.0),
        doubleArrayOf(0.0, 0.0, 0.02, 0.0, 0.0),
    ),
    arrayOf(
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0),
        doubleArrayOf(0.0, 0.01, 0.0, 0.01, 0.0),
        doubleArrayOf(0.02, 0.07, 0.0, 0.07, 0.02),
        doubleArrayOf(0.0, 0.10, 0.0, 0.10, 0.0),
        doubleArrayOf(0.0, 0.0, 0.05, 0.0, 0.0),
    ),
    arrayOf(
        doubleArrayOf(0.0, 0.0, 0.02, 0.0, 0.0),
        doubleArrayOf(0.0, 0.01, 0.07, 0.10, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.05),
        doubleArrayOf(0.0, 0.01, 0.07, 0.10, 0.0),
        doubleArrayOf(0.0, 0.0, 0.02, 0.0, 0.0),
    ),
    arrayOf(
        doubleArrayOf(0.0, 0.0, 0.05, 0.0, 0.0),
        doubleArrayOf(0.0, 0.10, 0.0, 0.10, 0.0),
        doubleArrayOf(0.02, 0.07, 0.0, 0.07, 0.02),
        doubleArrayOf(0.0, 0.01, 0.0, 0.01, 0.0),
        doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0),
    ),
)

private val dx = arrayOf(
    intArrayOf(-2, -2, -2, -2, -2),
    intArrayOf(-1, -1, -1, -1, -1),
    intArrayOf(0, 0, 0, 0, 0),
    intArrayOf(1, 1, 1, 1, 1),
    intArrayOf(2, 2, 2, 2, 2)
)
private val dy = arrayOf(
    intArrayOf(-2, -1, 0, 1, 2),
    intArrayOf(-2, -1, 0, 1, 2),
    intArrayOf(-2, -1, 0, 1, 2),
    intArrayOf(-2, -1, 0, 1, 2),
    intArrayOf(-2, -1, 0, 1, 2),
)

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val map = Array(n) {
        val st = StringTokenizer(br.readLine(), " ")
        IntArray(n) { st.nextToken().toInt() }
    }

    var tx = n / 2
    var ty = n / 2
    var dir = LEFT
    var outsideSum = 0

    while (tx != 0 || ty != 0) {
        when (dir) {
            LEFT -> {
                ty--
                var scatteredSum = 0
                for (i in 0..4) {
                    for (j in 0..4) {
                        if (percents[dir][i][j] <= 0.0) continue
                        val x = tx + dx[i][j]
                        val y = ty + dy[i][j]

                        val scattered = (map[tx][ty] * percents[dir][i][j]).toInt()
                        scatteredSum += scattered

                        if (x in map.indices && y in map.indices) {
                            map[x][y] += scattered
                        } else {
                            outsideSum += scattered
                        }
                    }
                }
                if (ty > 0) {
                    map[tx][ty - 1] += map[tx][ty] - scatteredSum
                } else {
                    outsideSum += map[tx][ty] - scatteredSum
                }
                map[tx][ty] = 0
                if (tx == ty + 1)
                    dir = BOTTOM
            }
            BOTTOM -> {
                tx++
                var scatteredSum = 0
                for (i in 0..4) {
                    for (j in 0..4) {
                        if (percents[dir][i][j] <= 0.0) continue
                        val x = tx + dx[i][j]
                        val y = ty + dy[i][j]

                        val scattered = (map[tx][ty] * percents[dir][i][j]).toInt()
                        scatteredSum += scattered

                        if (x in map.indices && y in map.indices) {
                            map[x][y] += scattered
                        } else {
                            outsideSum += scattered
                        }
                    }
                }
                if (tx < n - 1) {
                    map[tx + 1][ty] += map[tx][ty] - scatteredSum
                } else {
                    outsideSum += map[tx][ty] - scatteredSum
                }
                map[tx][ty] = 0
                if (tx + ty == n - 1)
                    dir = RIGHT
            }
            RIGHT -> {
                ty++
                var scatteredSum = 0
                for (i in 0..4) {
                    for (j in 0..4) {
                        if (percents[dir][i][j] <= 0.0) continue
                        val x = tx + dx[i][j]
                        val y = ty + dy[i][j]

                        val scattered = (map[tx][ty] * percents[dir][i][j]).toInt()
                        scatteredSum += scattered

                        if (x in map.indices && y in map.indices) {
                            map[x][y] += scattered
                        } else {
                            outsideSum += scattered
                        }
                    }
                }
                if (ty < n - 1) {
                    map[tx][ty + 1] += map[tx][ty] - scatteredSum
                } else {
                    outsideSum += map[tx][ty] - scatteredSum
                }
                map[tx][ty] = 0
                if (tx == ty)
                    dir = TOP
            }
            TOP -> {
                tx--
                var scatteredSum = 0
                for (i in 0..4) {
                    for (j in 0..4) {
                        if (percents[dir][i][j] <= 0.0) continue
                        val x = tx + dx[i][j]
                        val y = ty + dy[i][j]

                        val scattered = (map[tx][ty] * percents[dir][i][j]).toInt()
                        scatteredSum += scattered

                        if (x in map.indices && y in map.indices) {
                            map[x][y] += scattered
                        } else {
                            outsideSum += scattered
                        }
                    }
                }
                if (tx > 0) {
                    map[tx - 1][ty] += map[tx][ty] - scatteredSum
                } else {
                    outsideSum += map[tx][ty] - scatteredSum
                }
                map[tx][ty] = 0
                if (tx + ty == n - 1)
                    dir = LEFT
            }
        }
    }
    println(outsideSum)
}
