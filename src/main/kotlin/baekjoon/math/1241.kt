package baekjoon.math

import kotlin.math.sqrt

class `1241` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val S = List(N) { readLine().toInt() }
        val counter = buildMap<Int, Int> {
            S.forEach { this[it] = getOrDefault(it, 0) + 1 }
        }
        val answer = IntArray(N)
        for (i in S.indices) {
            for (aliquot in 1..sqrt(S[i].toDouble()).toInt()) {
                if (S[i] % aliquot == 0) {
                    answer[i] += if (aliquot * aliquot == S[i]) counter.getOrDefault(aliquot, 0)
                    else (counter.getOrDefault(aliquot, 0) + counter.getOrDefault(S[i].div(aliquot), 0))
                }
            }
            answer[i]--
        }

        print(answer.joinToString("\n"))
    }
}

fun main() {
    `1241`().solution()
}