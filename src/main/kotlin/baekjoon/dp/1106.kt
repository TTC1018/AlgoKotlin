package baekjoon.dp

import kotlin.math.min

class `1106` {

    data class CusInfo(
        val cost: Int,
        val num: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val (C, N) = readLine().split(" ").map { it.toInt() }
        val dp = IntArray(C + 100) { Int.MAX_VALUE }
        val costs = mutableListOf<CusInfo>()

        repeat(N) {
            val (cost, customerNum) = readLine().split(" ").map { it.toInt() }
            costs.add(CusInfo(cost, customerNum))
        }

        dp[0] = 0
        costs.sortBy { it.cost }
        for ((cost, num) in costs) {
            for (i in num until 100 + C) {
                if (dp[i - num] != Int.MAX_VALUE)
                    dp[i] = min(dp[i], dp[i - num] + cost)
            }
        }

        print(dp.slice(C until dp.size).minOf { it })
    }

}

fun main() {

    `1106`().solution()

}