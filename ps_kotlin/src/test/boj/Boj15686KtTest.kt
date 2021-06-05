package boj

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Boj15686KtTest {
    @Test
    fun test01() {
        val m = 13
        val map = Array(50) { IntArray(50) }
        val storeList = listOf(
            intArrayOf(5, 5),
            intArrayOf(5, 6),
            intArrayOf(5, 7),
            intArrayOf(5, 8),
            intArrayOf(5, 9),
            intArrayOf(5, 10),
            intArrayOf(5, 11),
            intArrayOf(5, 12),
            intArrayOf(5, 13),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
        )
        map[1][1] = 1
        for (pos in storeList) {
            map[pos[0]][pos[1]] = 2
        }

        assertEquals(1, boj15686(m, map, storeList))
    }
}