import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = IntArray(n) { br.readLine().toInt() }
    arr.sort()

    for (i in arr) {
        bw.write(i.toString())
        bw.newLine()
    }
    bw.flush()
}
