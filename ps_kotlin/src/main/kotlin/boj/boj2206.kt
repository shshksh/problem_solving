package boj


fun main() {
    class Pos(val x: Int, val y: Int, val item: Boolean)

    val br = System.`in`.bufferedReader()
    val offset = arrayOf(
        intArrayOf(-1, 0, 1, 0),
        intArrayOf(0, 1, 0, -1)
    )

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { br.readLine().toCharArray() }

    val q = ArrayDeque<Pos>()
    var count = 0

    q.addLast(Pos(0, 0, true))
    map[0][0] = '2'

    while (q.isNotEmpty()) {
        val t = q.size
        count++

        repeat(t) {
            val pos = q.removeFirst()

            if (pos.x == n - 1 && pos.y == m - 1) {
                println(count)
                return
            }

            for (i in 0..3) {
                val x = pos.x + offset[0][i]
                val y = pos.y + offset[1][i]

                if (x !in map.indices || y !in map[0].indices || map[x][y] == '2') {
                    continue
                }
                if (map[x][y] == '3' && !pos.item) {
                    continue
                }
                if (map[x][y] == '1') {
                    if (!pos.item) {
                        continue
                    } else {
                        q.addLast(Pos(x, y, false))
                    }
                } else {
                    q.addLast(Pos(x, y, pos.item))
                    map[x][y] = if (pos.item) '2' else '3'
                }
            }
        }
    }

    println(-1)
}


/*
4 4
0000
0000
0001
0010

4 4
0000
0001
0011
0110

1 1
0

1 1
1

1 2
00

9 8
00000000
11111110
00000000
01111111
00000000
11111110
00000000
01111111
00000000

13 13
0100011011000
0001001010000
0000100001000
1100010101011
1111101111000
1011010001001
0100001001001
0100111010001
0101010000100
0001110100000
0000001000100
1010001000111
1001000100000

 */
