package baekjoon.greedy

import kotlin.math.absoluteValue

class `1455` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().map(Char::digitToInt).toIntArray() }

        var answer = 0
        for (i in N - 1 downTo 0) {
            for (j in M - 1 downTo 0) {
                if (B[i][j] == 1) {
                    answer++
                    for (x in 0..i) {
                        for (y in 0..j) {
                            B[x][y] = (B[x][y] - 1).absoluteValue
                        }
                    }
                }
            }
        }
        print(answer)
    }
}