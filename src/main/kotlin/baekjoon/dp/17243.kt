package baekjoon.dp

import kotlin.math.max

class `17243` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (n, K) = readLine().split(" ").map { it.toInt() }
        val A = readLine().split(" ").map { it.toInt() }.toIntArray()
        val dp = Array(n + 1) { IntArray(K + 1) { 1 } }

        for (i in 1 until n + 1) {
            for (j in 1 until i) {
                when {
                    A[j - 1] <= A[i - 1] -> {
                        for (k in 0..K) {
                            dp[i][k] = max(dp[i][k], dp[j][k] + 1)
                        }
                    }

                    else -> {
                        for (k in 0 until K) {
                            dp[i][k + 1] = max(dp[i][k + 1], dp[j][k] + 1)
                        }
                    }
                }
            }
        }
        println(dp[n].maxOf { it })
    }

}

fun main() {

    `17243`().solution()

}