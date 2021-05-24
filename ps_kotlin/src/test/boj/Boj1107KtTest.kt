package boj

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Boj1107KtTest {

    @Test
    fun test1() {
        val result = boj1107("5457", "6 7 8")
        assertEquals(result, 6)
    }

    @Test
    fun test2() {
        val result = boj1107("100", "0 1 2 3 4")
        assertEquals(result, 0)
    }

    @Test
    fun test3() {
        val result = boj1107("500000", "0 2 3 4 6 7 8 9")
        assertEquals(result, 11117)
    }

    @Test
    fun test4() {
        val result = boj1107("5999", "3 4 7 8 9")
        assertEquals(result, 5)
    }

    @Test
    fun test5() {
        val result = boj1107("0", "0 1 2 3 4 5 6 7 8 9")
        assertEquals(result, 100)
    }

    @Test
    fun test6() {
        val result = boj1107("0", "0 1 2 3 4 5 6 7 8")
        assertEquals(result, 10)
    }

    @Test
    fun test7() {
        val result = boj1107("103", "")
        assertEquals(result, 3)
    }

    @Test
    fun test8() {
        val result = boj1107("104", "")
        assertEquals(result, 3)
    }

    @Test
    fun test9() {
        val result = boj1107("500000", "5")
        assertEquals(result, 7)
    }

    @Test
    fun test10() {
        val result = boj1107("99999", "9")
        assertEquals(result, 7)
    }

    @Test
    fun test11() {
        val result = boj1107("1555", "0 1 3 4 5 6 7 9")
        assertEquals(result, 670)
    }

    @Test
    fun test12() {
        val result = boj1107("98", "0 1 2 3 4 5 6 7 8 9")
        assertEquals(result, 2)
    }

    @Test
    fun test13() {
        val result = boj1107("1", "1 2")
        assertEquals(result, 2)
    }

    @Test
    fun test14() {
        val result = boj1107("40", "1 2 3 4 5 6 7 8 9")
        assertEquals(result, 41)
    }

}