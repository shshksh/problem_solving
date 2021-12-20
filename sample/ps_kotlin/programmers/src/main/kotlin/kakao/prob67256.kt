package kakao

import kotlin.math.abs

fun solution(numbers: IntArray, hand: String): String {
    var result = ""
    var lastLeft = 3 to 0
    var lastRight = 3 to 2

    for (number in numbers) {
        when (number) {
            1, 4, 7 -> {
                result += "L"
                lastLeft = number / 3 to 0
            }
            3, 6, 9 -> {
                result += "R"
                lastRight = number / 3 - 1 to 2
            }
            2, 5, 8, 0 -> {
                val x = if (number == 0) 3 else number / 3
                val y = 1

                val ld = abs(x - lastLeft.first) + abs(y - lastLeft.second)
                val rd = abs(x - lastRight.first) + abs(y - lastRight.second)

                if (ld < rd || ld == rd && hand == "left") {
                    result += "L"
                    lastLeft = x to y
                } else if (ld > rd || ld == rd && hand == "right") {
                    result += "R"
                    lastRight = x to y
                }
            }
        }
    }

    return result
}
