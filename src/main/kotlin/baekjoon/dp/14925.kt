package baekjoon.dp

import kotlin.math.max

class `14925` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (M, N) = readLine().split(" ").map { it.toInt() }
        val board = Array(M) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        var answer = 0
        val dp = Array(M) { IntArray(N) }
            .also {
                for (i in 0 until M)
                    if (board[i][0] == 0) {
                        it[i][0] = 1
                        answer = 1
                    }
                for (i in 0 until N)
                    if (board[0][i] == 0) {
                        it[0][i] = 1
                        answer = 1
                    }
            }


        for (i in 1 until M){
            for (j in 1 until N){
                if (board[i][j] == 0)
                    dp[i][j] = max(dp[i][j], minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1)
                answer = max(answer, dp[i][j])
            }
        }

        print(answer)
    }

}

fun main() {

    `14925`().solution()

}