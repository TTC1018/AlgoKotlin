package baekjoon.dp

import kotlin.math.max

class `7579` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val m = readLine().split(" ").map { it.toInt() }.toIntArray()
        val c = readLine().split(" ").map { it.toInt() }.toIntArray()

        val limit = c.sumOf { it }
        val dp = Array(N + 1) { IntArray(limit + 1) }
        for (i in 1..N) {
            for (cost in 0..limit) {
                dp[i][cost] = max(dp[i][cost], dp[i - 1][cost])

                val diff = cost - c[i - 1]
                if (diff >= 0)
                    dp[i][cost] = max(dp[i][cost], dp[i - 1][diff] + m[i - 1])
            }
        }
        print(dp[N].indexOfFirst { it >= M })
    }

}

fun main() {

    `7579`().solution()

}