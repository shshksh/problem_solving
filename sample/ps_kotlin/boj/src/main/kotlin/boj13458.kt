import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.ceil

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val students = br.readLine().split(" ")
    val (main, sub) = br.readLine().split(" ")

    println(n + calc(students, main, sub))
}

private fun calc(
    students: List<String>,
    main: String,
    sub: String,
): Long = students.map { it.toInt() - main.toInt() }
    .filter { it > 0 }
    .map { ceil(it.toDouble() / sub.toInt()).toLong() }
    .sum()
