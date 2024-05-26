package baekjoon.math

import kotlin.math.pow

class `1951` {
    private val MOD = 1234567

    private fun pow10(n: Int): Long = (10.0).pow(n).toLong()

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toLong()
        val L = "$N".length
        var answer = 0L
        var l = L
        while (--l > 0) {
            answer += (pow10(l) - pow10(l - 1)) * l
            answer %= MOD
        }

        answer += (N - pow10(L - 1) + 1) * L
        answer %= MOD
        print(answer)
    }
}