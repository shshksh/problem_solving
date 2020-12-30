import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HelloWorldKtTest {

    @Test
    fun getHelloWorldTest() {
        println(getHelloWorld())
        assertEquals(1+1, 2)
    }
}