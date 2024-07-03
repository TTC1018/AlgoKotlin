package baekjoon.math

import kotlin.math.log2

class `31926` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toDouble()
        print(8L + kotlin.math.floor(log2(N)).toLong() + 2L)
    }
}