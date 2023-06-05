package baekjoon.math

import kotlin.math.sqrt

class `9421` {

    private var n = 0
    private lateinit var primes: BooleanArray

    private fun generatePrimes() {
        for (num in 2..sqrt(n.toDouble()).toInt()) {
            if (primes[num]) {
                for (nxt in num*2..n step num) {
                    primes[nxt] = false
                }
            }
        }
    }

    private fun isAnswer(num: Int): Boolean {
        if (primes[num].not())
            return false

        var prev = num.toString().toCharArray().sumOf { it.digitToInt()*it.digitToInt() }
        val tmp = mutableSetOf<Int>()
        while (prev != 1 && prev !in tmp) {
            tmp.add(prev)
            prev = prev.toString().toCharArray().sumOf { it.digitToInt() * it.digitToInt() }
        }

        return prev == 1
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        n = readLine().toInt()
        primes = BooleanArray(n + 1) { true }
            .also { it[1] = false }
        generatePrimes()
        print((2..n).filter { isAnswer(it) }.joinToString("\n"))
    }

}

fun main() {

    `9421`().solution()

}