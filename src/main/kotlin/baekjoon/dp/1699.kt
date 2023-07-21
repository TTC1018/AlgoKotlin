package baekjoon.dp

import kotlin.math.floor
import kotlin.math.sqrt

class `1699` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val dp = IntArray(N + 1) { Int.MAX_VALUE }
            .also { it[0] = 0; it[1] = 1 }

        for (num in 2..N) {
            for (square in 1..floor(sqrt(num.toDouble())).toInt()) {
                dp[num] = minOf(dp[num], dp[num - square*square] + 1)
            }
        }
        print(dp[N])
    }
}

fun main() {
    `1699`().solution()
}