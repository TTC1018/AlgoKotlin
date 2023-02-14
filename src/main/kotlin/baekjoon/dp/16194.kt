package baekjoon.dp

import kotlin.math.min

class `16194` {

    fun solution() = with(System.`in`.bufferedReader()){

        val N = readLine().toInt()
        val P = readLine().split(" ").map { it.toInt() }.toIntArray()
        val dp = IntArray(1000 + 1) { 10000 }
        dp[0] = 0

        for (card in 1..1000){
            for (num in 1 .. N){
                if (num <= card)
                    dp[card] = min(dp[card], dp[card - num] + P[num - 1])
            }
        }

        print(dp[N])
    }

}

fun main() {

    `16194`().solution()

}