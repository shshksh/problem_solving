package boj

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Boj14500KtTest {
    @Test
    fun test01() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[498][498] = 1000
        arr[498][499] = 1000
        arr[499][498] = 1000
        arr[499][499] = 1000
        // 1 1
        // 1 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test02() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[499][496] = 1000
        arr[499][497] = 1000
        arr[499][498] = 1000
        arr[499][499] = 1000
        // 1 1 1 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test03() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[496][499] = 1000
        arr[497][499] = 1000
        arr[498][499] = 1000
        arr[499][499] = 1000
        // 1
        // 1
        // 1
        // 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test04() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[499][497] = 1000
        arr[499][498] = 1000
        arr[498][498] = 1000
        arr[498][499] = 1000
        //   1 1
        // 1 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test05() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[497][498] = 1000
        arr[498][498] = 1000
        arr[498][499] = 1000
        arr[499][499] = 1000
        // 1
        // 1 1
        //   1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test06() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[498][499] = 1000
        arr[499][499] = 1000
        arr[499][498] = 1000
        arr[499][497] = 1000
        //     1
        // 1 1 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test07() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[497][498] = 1000
        arr[498][498] = 1000
        arr[499][498] = 1000
        arr[499][499] = 1000
        // 1
        // 1
        // 1 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test08() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[499][497] = 1000
        arr[498][497] = 1000
        arr[498][498] = 1000
        arr[498][499] = 1000
        // 1 1 1
        // 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test09() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[497][498] = 1000
        arr[497][499] = 1000
        arr[498][499] = 1000
        arr[499][499] = 1000
        // 1 1
        //   1
        //   1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test10() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[498][497] = 1000
        arr[498][498] = 1000
        arr[498][499] = 1000
        arr[499][498] = 1000
        // 1 1 1
        //   1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test11() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[497][499] = 1000
        arr[498][499] = 1000
        arr[499][499] = 1000
        arr[498][498] = 1000
        //   1
        // 1 1
        //   1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test12() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[498][498] = 1000
        arr[499][497] = 1000
        arr[499][498] = 1000
        arr[499][499] = 1000
        //   1
        // 1 1 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test13() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[497][498] = 1000
        arr[498][498] = 1000
        arr[499][498] = 1000
        arr[498][499] = 1000
        // 1
        // 1 1
        // 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test14() {
        val (height, width) = 4 to 4
        val arr = Array(height) { IntArray(width) { 1 } }
        arr[1][1] = 1000
        arr[1][2] = 1000
        arr[2][1] = 1000
        arr[2][2] = 1000

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test15() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[497][499] = 1000
        arr[498][499] = 1000
        arr[498][498] = 1000
        arr[499][499] = 1000
        //   1
        // 1 1
        // 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test16() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[498][497] = 1000
        arr[498][498] = 1000
        arr[499][498] = 1000
        arr[499][499] = 1000
        // 1 1
        //   1 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test17() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[497][499] = 1000
        arr[498][499] = 1000
        arr[499][499] = 1000
        arr[499][498] = 1000
        //   1
        //   1
        // 1 1

        assertEquals(4000, boj14500(width, height, arr))
    }

    @Test
    fun test18() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[498][497] = 1000
        arr[499][497] = 1000
        arr[499][498] = 1000
        arr[499][499] = 1000
        // 1
        // 1 1 1

        assertEquals(4000, boj14500(width, height, arr))
    }
    @Test
    fun test19() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[497][498] = 1000
        arr[497][499] = 1000
        arr[498][498] = 1000
        arr[499][498] = 1000
        // 1 1
        // 1
        // 1

        assertEquals(4000, boj14500(width, height, arr))
    }
    @Test
    fun test20() {
        val (height, width) = 500 to 500
        val arr = Array(500) { IntArray(500) { 1 } }
        arr[498][497] = 1000
        arr[498][498] = 1000
        arr[498][499] = 1000
        arr[499][499] = 1000
        // 1 1 1
        //     1

        assertEquals(4000, boj14500(width, height, arr))
    }

}