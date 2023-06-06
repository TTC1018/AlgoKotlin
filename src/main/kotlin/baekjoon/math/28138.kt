package baekjoon.math

import kotlin.math.sqrt

class `28138` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, R) = readLine().split(" ").map { it.toLong() }
        var answer = 0L
        for (num in 1..sqrt((N - R).toDouble()).toLong()) {
            if ((N - R) % num == 0L) {
                if (num > R)
                    answer += num
                if (num*num != (N-R) && (N-R).div(num) > R)
                    answer += (N-R).div(num)
            }
        }
        print(answer)
    }

}

fun main() {

    `28138`().solution()

}