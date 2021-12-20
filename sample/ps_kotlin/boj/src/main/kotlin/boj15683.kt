import java.util.*

private val dx = arrayOf(
    arrayOf(intArrayOf(-1), intArrayOf(0), intArrayOf(1), intArrayOf(0)),
    arrayOf(intArrayOf(0, 0), intArrayOf(-1, 1)),
    arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1)),
    arrayOf(
        intArrayOf(-1, 0, 0),
        intArrayOf(-1, 0, 1),
        intArrayOf(0, 1, 0),
        intArrayOf(-1, 0, 1)
    ),
    arrayOf(intArrayOf(-1, 0, 1, 0)),
)
private val dy = arrayOf(
    arrayOf(intArrayOf(0), intArrayOf(1), intArrayOf(0), intArrayOf(-1)),
    arrayOf(intArrayOf(-1, 1), intArrayOf(0, 0)),
    arrayOf(intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0)),
    arrayOf(
        intArrayOf(0, -1, 1),
        intArrayOf(0, -1, 0),
        intArrayOf(-1, 0, 1),
        intArrayOf(0, 1, 0)
    ),
    arrayOf(intArrayOf(0, 1, 0, -1))
)
private lateinit var cctv: MutableList<Pair<Int, Int>>

private lateinit var office: Array<IntArray>

private var area = 64

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    cctv = mutableListOf()
    office = Array(n) { i ->
        val st = StringTokenizer(br.readLine())
        IntArray(m) { j ->
            val token = st.nextToken().toInt()
            if (token in 1..5) cctv.add(i to j)
            token
        }
    }

    dfs(0)

    println(area)
}

fun dfs(start: Int) {
    if (start == cctv.size) {
        area = minOf(area, office.sumOf { row -> row.count { it == 0 } })
        return
    }
    val x = cctv[start].first
    val y = cctv[start].second
    val cameraNumber = office[x][y] - 1
    val rotation = dx[cameraNumber]

    for (r in rotation.indices) {
        val direction = dx[cameraNumber][r]
        for (dir in direction.indices) {
            val xDir = dx[cameraNumber][r][dir]
            val yDir = dy[cameraNumber][r][dir]

            check(x, y, xDir, yDir, true)
        }
        dfs(start + 1)
        for (dir in direction.indices) {
            val xDir = dx[cameraNumber][r][dir]
            val yDir = dy[cameraNumber][r][dir]

            check(x, y, xDir, yDir, false)
        }
    }
}

fun check(x: Int, y: Int, xDir: Int, yDir: Int, flag: Boolean) {
    var cx = x + xDir
    var cy = y + yDir

    while (true) {
        if (cx < 0 || cy < 0 || cx >= office.size || cy >= office[0].size || office[cx][cy] == 6)
            return
        if (flag && office[cx][cy] <= 0)
            office[cx][cy]--
        else if (!flag && office[cx][cy] < 0)
            office[cx][cy]++
        cx += xDir
        cy += yDir
    }
}
