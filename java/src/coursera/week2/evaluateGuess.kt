package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0
    val list = mutableListOf<Char>()

    for (withIndex in guess.withIndex()) {
        if (secret[withIndex.index] == withIndex.value) {
            rightPosition++
        } else {
            list.add(secret[withIndex.index])
        }
    }

    for (withIndex in guess.withIndex()) {
        if (secret[withIndex.index] != withIndex.value) {
            if (list.contains(withIndex.value)) {
                list.remove(withIndex.value)
                wrongPosition++
            }
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}
