import java.util.*

private val dx = intArrayOf(0, 0, -1, -1, -1, 0, 1, 1, 1)
private val dy = intArrayOf(0, -1, -1, 0, 1, 1, 1, 0, -1)
private val copyDx = intArrayOf(-1, -1, 1, 1)
private val copyDy = intArrayOf(-1, 1, 1, -1)

private data class Pos(var x: Int, var y: Int)

fun main() {

    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val mat = Array(n) { val st = StringTokenizer(br.readLine(), " "); IntArray(n) { st.nextToken().toInt() } }

    val clouds = mutableListOf<Pos>().apply {
        add(Pos(n - 2, 0))
        add(Pos(n - 2, 1))
        add(Pos(n - 1, 0))
        add(Pos(n - 1, 1))
    }

    for (i in 1..m) {
        val (dir, offset) = br.readLine().split(" ").map { it.toInt() }

        move(clouds, dir, offset, n)

        rain(clouds, mat)

        copy(clouds, mat)

        makeClouds(mat, clouds)
    }

    println(mat.sumOf { it.sum() })
}

private fun move(clouds: MutableList<Pos>, dir: Int, offset: Int, n: Int) {
    for (cloud in clouds) {
        cloud.x = (cloud.x + dx[dir] * offset) % n
        cloud.y = (cloud.y + dy[dir] * offset) % n

        if (cloud.x < 0) cloud.x += n
        if (cloud.y < 0) cloud.y += n
    }
}

private fun rain(clouds: MutableList<Pos>, mat: Array<IntArray>) {
    for (cloud in clouds) {
        mat[cloud.x][cloud.y]++
    }
}

private fun copy(clouds: MutableList<Pos>, mat: Array<IntArray>) {
    for (cloud in clouds) {
        for (j in 0..3) {
            val copyX = cloud.x + copyDx[j]
            val copyY = cloud.y + copyDy[j]

            if (copyX in mat.indices && copyY in mat.indices) {
                if (mat[copyX][copyY] > 0)
                    mat[cloud.x][cloud.y]++
            }
        }
    }
}

private fun makeClouds(mat: Array<IntArray>, clouds: MutableList<Pos>) {
    val newClouds = mutableListOf<Pos>()
    for (j in mat.indices) {
        for (k in mat.indices) {
            if (mat[j][k] >= 2 && Pos(j, k) !in clouds) {
                newClouds.add(Pos(j, k))
                mat[j][k] -= 2
            }
        }
    }
    clouds.clear()
    clouds.addAll(newClouds)
}
