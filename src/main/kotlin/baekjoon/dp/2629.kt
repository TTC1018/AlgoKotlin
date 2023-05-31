package baekjoon.dp

import kotlin.math.absoluteValue

class `2629` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val W = readLine().split(" ").map { it.toInt() }
        val M = readLine().toInt()
        val B = readLine().split(" ").map { it.toInt() }.toIntArray()

        val maxW = W.maxOf { it }
        val dp = Array(N) { BooleanArray(N * maxW + 1) }
        dp[0][0] = true // 안 올리는 경우 = 0 달성
        dp[0][W[0]] = true
        for (i in 1 until N) {
            dp[i][W[i]] = true // 단일로 올린 경우
            for (totalW in 0..N*maxW) {
                // 안 올리는 경우 or 반대편(우측)에 올리는 경우
                dp[i][totalW] = dp[i - 1][totalW] or dp[i - 1][(totalW - W[i]).absoluteValue]
                if (totalW + W[i] <= N*maxW) // 좌측에 올리는 경우
                    dp[i][totalW] = dp[i][totalW] or dp[i - 1][totalW + W[i]]
            }
        }

        mutableListOf<Char>().apply {
            for (b in B)
                add(if (b <= N*maxW && dp[N-1][b]) 'Y' else 'N')
        }.also {
            print(it.joinToString(" "))
        }
    }

}

fun main() {

    `2629`().solution()

}