package solution

import java.math.BigInteger

class Rational(a: Number, b: Number) : Comparable<Rational> {
    private var n: BigInteger = 0.toBigInteger()
    private var d: BigInteger = 1.toBigInteger()

    init {
        n = when (a) {
            is Int -> a.toBigInteger()
            is Long -> a.toBigInteger()
            is BigInteger -> a
            else -> throw IllegalArgumentException()
        }
        d = when (b) {
            is Int -> b.toBigInteger()
            is Long -> b.toBigInteger()
            is BigInteger -> b
            else -> throw IllegalArgumentException()
        }

        if (d < 0.toBigInteger()) {
            d *= (-1).toBigInteger()
            n *= (-1).toBigInteger()
        }

        val gcd = n.gcd(d)
        n /= gcd
        d /= gcd
    }

    operator fun plus(x: Rational): Rational = Rational((this.n * x.d + this.d * x.n), this.d * x.d)

    operator fun minus(x: Rational): Rational = Rational((this.n * x.d - this.d * x.n), this.d * x.d)

    operator fun times(x: Rational): Rational = Rational(this.n * x.n, this.d * x.d)

    operator fun div(x: Rational): Rational = Rational(this.n * x.d, this.d * x.n)

    operator fun unaryMinus(): Rational = Rational(this.n * (-1).toBigInteger(), this.d)

    override fun toString(): String = if (d == 1.toBigInteger()) "$n" else "$n/$d"

    override fun compareTo(other: Rational): Int {
        val result = (this - other).n
        return result.compareTo(0.toBigInteger())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (n != other.n) return false
        if (d != other.d) return false

        return true
    }

    override fun hashCode(): Int {
        var result = n.hashCode()
        result = 31 * result + d.hashCode()
        return result
    }
}

infix fun Number.divBy(x: Number): Rational = Rational(this, x)

fun String.toRational(): Rational {
    val split = this.split("/")
    return if (split.size > 1)
        Rational(split[0].toBigInteger(), split[1].toBigInteger())
    else
        Rational(split[0].toBigInteger(), 1.toBigInteger())
}

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}