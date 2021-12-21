import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    repeat(br.readLine().toInt()) {
        val map = TreeMap<Int, Int>()
        repeat(br.readLine().toInt()) {
            val command = br.readLine().split(" ")
            val value = command[1].toInt()
            when (command[0]) {
                "I" -> {
                    map[value] = map.getOrDefault(value, 0) + 1
                }
                "D" -> {
                    if (map.isNotEmpty()) {
                        val key = if (value == 1) map.lastKey() else map.firstKey()
                        if (map[key] == 1)
                            map.remove(key)
                        else
                            map[key] = map.getValue(key) - 1
                    }
                }
            }
        }
        if (map.isEmpty())
            bw.write("EMPTY\n")
        else
            bw.write("${map.lastKey()} ${map.firstKey()}\n")
    }
    bw.flush()
}
