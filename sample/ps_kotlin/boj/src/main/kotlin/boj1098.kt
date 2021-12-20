import kotlin.math.sqrt

fun main() {
    var count = 0
    readLine()!!
    readLine()!!.split(" ").forEach {
        if (it.toInt() == 1)
            return@forEach
        for (i in 2..sqrt(it.toDouble()).toInt()) {
            if (it.toInt() % i == 0)
                return@forEach
        }
        count++
    }
    println(count)
}
