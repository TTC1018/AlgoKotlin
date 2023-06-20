package baekjoon.prefixsum

import kotlin.math.max
import kotlin.math.min

class `27210` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val S = readLine().split(" ").map(String::toInt).toIntArray()
        val L = IntArray(N + 1)
        val R = IntArray(N + 1)
        IntArray(N + 1).also {
            for (i in 1..N) {
                it[i] += (it[i - 1] + when (S[i - 1]) {
                    1 -> 1
                    else -> -1
                })
            }

            for (i in 1..N) {
                L[i] = max(L[i - 1], it[i])
                R[i] = min(R[i - 1], it[i])
            }
        }

        print(L.zip(R).maxOf { it.first - it.second })
    }

}

fun main() {

    `27210`().solution()

}