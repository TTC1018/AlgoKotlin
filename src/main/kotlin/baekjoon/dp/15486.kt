package baekjoon.dp

import kotlin.math.max

class `15486` {

    data class Counsel(
        val t: Int,
        val p: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val C = Array(N) { readLine().split(" ").map { it.toInt() }.run { Counsel(this[0], this[1]) } }
        val dp = IntArray(N + 1)

        var prevMax = 0
        for (i in 0 until N){
            prevMax = max(prevMax, dp[i])
            val nxt = i + C[i].t
            if (nxt <= N){
                dp[nxt] = max(dp[nxt], prevMax + C[i].p)
            }
        }

        println(dp.maxOf { it })
    }

}

fun main() {

    `15486`().solution()

}