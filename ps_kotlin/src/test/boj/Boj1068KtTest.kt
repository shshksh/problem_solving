package boj

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Boj1068KtTest {

    @Test
    fun test1() {
        val result = leafOf(5, listOf(-1, 0, 0, 1, 1), 2)
        assertEquals(result, 2)
    }

    @Test
    fun test2() {
        val result = leafOf(5, listOf(-1, 0, 0, 1, 1), 1)
        assertEquals(result, 1)
    }

    @Test
    fun test3() {
        val result = leafOf(5, listOf(-1, 0, 0, 1, 1), 0)
        assertEquals(result, 0)
    }

    @Test
    fun test4() {
        val result = leafOf(9, listOf(-1, 0, 0, 2, 2, 4, 4, 6, 6), 4)
        assertEquals(result, 2)
    }

    @Test
    fun test5() {
        val result = leafOf(6, listOf(5, 5, 0, 0, 1, -1), 5)
        assertEquals(result, 0)
    }

    @Test
    fun test6() {
        val result = leafOf(6, listOf(5, 5, 0, 0, 1, -1), 0)
        assertEquals(result, 1)
    }

    @Test
    fun test7() {
        val result = leafOf(6, listOf(5, 5, 0, 0, 1, -1), 1)
        assertEquals(result, 2)
    }

    @Test
    fun test8() {
        val result = leafOf(6, listOf(5, 5, 0, 0, 1, -1), 2)
        assertEquals(result, 2)
    }

    @Test
    fun test9() {
        val result = leafOf(6, listOf(5, 5, 0, 0, 1, -1), 3)
        assertEquals(result, 2)
    }

    @Test
    fun test10() {
        val result = leafOf(6, listOf(5, 5, 0, 0, 1, -1), 4)
        assertEquals(result, 3)
    }
}