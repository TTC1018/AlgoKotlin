package baekjoon.baekjoon.math

import kotlin.math.sqrt

class `2023` {
    private var N = 0
    private val answer = StringBuilder()

    private fun isPrime(num: Int): Boolean {
        for (n in 2 until sqrt(num.toDouble()).toInt() + 1) {
            if (num % n == 0)
                return false
        }
        return true
    }

    private fun bruteforce(cnt: Int) {
        if (cnt == N) {
            println(answer)
            return
        }

        for (digit in 0..9) {
            answer.append(digit)
            if (isPrime(answer.toString().toInt())) {
                bruteforce(cnt + 1)
            }
            answer.deleteAt(answer.length - 1)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()

        for (digit in listOf(2, 3, 5, 7)) {
            answer.append(digit)
            bruteforce(1)
            answer.deleteAt(answer.length - 1)
        }
    }
}

fun main() {
    `2023`().solution()
}