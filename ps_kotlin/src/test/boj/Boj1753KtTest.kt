package boj

import org.junit.jupiter.api.Test

internal class Boj1753KtTest {
    @Test
    fun test1() {
        val vertexCount = 5
        val startVertex = 2
        val edges = arrayOf(
            intArrayOf(5, 1, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(1, 3, 3),
            intArrayOf(2, 3, 4),
            intArrayOf(2, 4, 5),
            intArrayOf(3, 4, 6),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test2() {
        val vertexCount = 5
        val startVertex = 1
        val edges = arrayOf(
            intArrayOf(1, 2, 6),
            intArrayOf(1, 2, 5),
            intArrayOf(1, 2, 4),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 2, 2),
            intArrayOf(1, 2, 1),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test3() {
        val vertexCount = 10
        val startVertex = 1
        val edges = arrayOf(
            intArrayOf(1, 10, 3)
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test4() {
        val vertexCount = 6
        val startVertex = 1
        val edges = arrayOf(
            intArrayOf(1, 2, 100),
            intArrayOf(1, 3, 1),
            intArrayOf(2, 4, 1),
            intArrayOf(2, 5, 1),
            intArrayOf(3, 4, 1),
            intArrayOf(3, 5, 300),
            intArrayOf(4, 6, 200),
            intArrayOf(5, 6, 1),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test5() {
        val vertexCount = 6
        val startVertex = 1
        val edges = arrayOf(
            intArrayOf(1, 2, 100),
            intArrayOf(1, 3, 1),
            intArrayOf(2, 4, 1),
            intArrayOf(2, 5, 1),
            intArrayOf(3, 4, 1),
            intArrayOf(3, 5, 300),
            intArrayOf(3, 5, 1),
            intArrayOf(4, 6, 200),
            intArrayOf(5, 6, 1),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test6() {
        val vertexCount = 6
        val startVertex = 5
        val edges = arrayOf(
            intArrayOf(1, 2, 100),
            intArrayOf(1, 3, 1),
            intArrayOf(2, 4, 1),
            intArrayOf(2, 5, 1),
            intArrayOf(3, 4, 1),
            intArrayOf(3, 5, 300),
            intArrayOf(4, 6, 200),
            intArrayOf(5, 6, 1),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test8() {
        val vertexCount = 3
        val startVertex = 3
        val edges = arrayOf(
            intArrayOf(1, 2, 100),
            intArrayOf(2, 3, 200),
            intArrayOf(3, 1, 300),
            intArrayOf(2, 1, 1),
            intArrayOf(1, 3, 2),
            intArrayOf(3, 2, 3),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test9() {
        val vertexCount = 6
        val startVertex = 1
        val edges = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 5, 1),
            intArrayOf(5, 6, 1),
            intArrayOf(1, 3, 10),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 3, 1),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test10() {
        val vertexCount = 5
        val startVertex = 1
        val edges = arrayOf(
            intArrayOf(1, 2, 2),
            intArrayOf(1, 3, 3),
            intArrayOf(2, 4, 1),
            intArrayOf(4, 5, 2),
            intArrayOf(3, 5, 1),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test11() {
        val vertexCount = 5
        val startVertex = 1
        val edges = arrayOf(
            intArrayOf(5, 1, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(1, 3, 4),
            intArrayOf(2, 3, 1),
            intArrayOf(2, 4, 11),
            intArrayOf(3, 4, 6),
        )

        boj1753(vertexCount, startVertex, edges)
    }

    @Test
    fun test12() {
        val vertexCount = 4
        val startVertex = 1
        val edges = arrayOf(
            intArrayOf(1, 3, 2),
            intArrayOf(3, 2, 4),
            intArrayOf(1, 4, 2),
            intArrayOf(4, 2, 1),
            intArrayOf(1, 3, 5),
        )

        boj1753(vertexCount, startVertex, edges)
    }
}