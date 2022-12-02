package baekjoon.dp

import kotlin.math.min

class `2294` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (n, k) = readLine().split(" ").map { it.toInt() }
        val coins = IntArray(n) { readLine().toInt() }
        val dp = IntArray(k + 1) { 1e9.toInt() }

        dp[0] = 0
        coins.filter { it <= k }.forEach { dp[it] = 1 }

        for (i in 1..k) {
            coins.forEach { coin ->
                if (i > coin){
                    dp[i] = min(dp[i], dp[i - coin] + 1)
                }
            }
        }

        if (dp[k] == 1e9.toInt())
            dp[k] = -1
        print(dp[k])
    }

}

fun main() {

    `2294`().solution()

}