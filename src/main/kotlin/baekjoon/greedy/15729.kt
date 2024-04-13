package baekjoon.greedy

import kotlin.math.absoluteValue

class `15729` {
    fun main() = with(System.`in`.bufferedReader()) {
        val N = readLine().trim().toInt()
        val T = readLine().trim().split(" ").map(String::toInt)
        val L = IntArray(N)
        var answer = 0
        for (i in 0 until N) {
            if (L[i] != T[i]) {
                answer++
                repeat(3) {
                    L.getOrNull(i + it)?.run {
                        L[i + it] = (this - 1).absoluteValue
                    }
                }
            }
        }
        print(answer)
    }
}