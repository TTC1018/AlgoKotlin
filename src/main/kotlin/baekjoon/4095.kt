package baekjoon

import kotlin.math.max

class `4095` {

    private var N = 0
    private var M = 0
    private lateinit var board: Array<IntArray>

    fun solution() = with(System.`in`.bufferedReader()) {

        val answers = mutableListOf<Int>()

        while (true){
            readLine().split(" ").map { it.toInt() }
                .also { N = it.first(); M = it.last() }
            if (N == 0 && M == 0)
                break

            var answer = 0
            board = Array(N) {
                val intArray = readLine().split(" ").map { it.toInt() }.toIntArray()
                if (1 in intArray) answer = 1
                intArray
            }
            val dp = Array(N) { board[it].clone() }

            for (i in 1 until N){
                for (j in 1 until M){
                    if (board[i][j] == 1){
                        dp[i][j] = minOf(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
                        answer = max(answer, dp[i][j])
                    }
                }
            }

            answers.add(answer)
        }

        print(answers.joinToString("\n"))
    }

}

fun main() {

    `4095`().solution()

}