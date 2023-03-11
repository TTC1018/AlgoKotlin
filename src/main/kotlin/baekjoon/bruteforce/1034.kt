package baekjoon.bruteforce

import kotlin.math.max

class `1034` {

    private var N = 0
    private var M = 0
    private lateinit var board: Array<IntArray>
    private var K = 0
    private var answer = 0

    private fun bruteforce(){

        for (row in 0 until N){
            val cnt = board[row].count { it == 0 }

            if (cnt <= K && cnt % 2 == K % 2){ // 0의 개수와 K가 다 짝수거나 홀수여야 됨
                val same = board.count { it.contentEquals(board[row]) }
                answer = max(answer, same)
            }

        }

    }

    fun solution() = with(System.`in`.bufferedReader()){

        readLine().split(" ").map { it.toInt() }
            .also { N = it.first(); M = it.last() }
        board = Array(N) { readLine().chunked(1).map { it.toInt() }.toIntArray() }
        K = readLine().toInt()

        bruteforce()

        print(answer)
    }

}

fun main(){

    `1034`().solution()

}