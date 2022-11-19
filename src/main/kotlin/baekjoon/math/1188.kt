package baekjoon.math

import kotlin.math.max
import kotlin.math.min

class `1188` {

    private fun euclidean(a: Int, b: Int): Int {
        val bigger = max(a, b)
        val smaller = min(a, b)

        var div = bigger
        var mod = smaller

        while (mod > 0) {
            val nextDiv = mod

            mod = div.rem(mod)
            div = nextDiv
        }

        return div
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        print(M - euclidean(N, M))

    }

}

fun main() {

    `1188`().solution()

}