package baekjoon.math

import kotlin.math.sqrt

private const val MAX_VAL = 2000 * 500

class `26090` {

    fun main() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nums = readLine().split(" ").map(String::toInt)
        val P = BooleanArray(MAX_VAL + 1) { true }.apply {
            if (size >= 2) {
                fill(false, 0, 2)
            }
            val limit = sqrt(MAX_VAL.toDouble()).toInt()
            for (n in 2..limit) {
                for (i in 2..MAX_VAL / n) {
                    this[n * i] = false
                }
            }
        }

        val S = nums.toIntArray().apply {
            for (i in 1 until size) {
                this[i] += this[i - 1]
            }
        }
        var cnt = 0L
        for (l in 2..N) {
            if (P.getOrNull(l) == true) {
                for (i in l - 1 until N) {
                    if (P[S[i] - (S.getOrNull(i - l) ?: 0)]) {
                        cnt++
                    }
                }
            }
        }
        print(cnt)
    }
}