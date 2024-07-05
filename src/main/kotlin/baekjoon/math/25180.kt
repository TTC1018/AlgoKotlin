package baekjoon.math

class `25180` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toLong()
        val answer = (N - 1).div(9) + 1
        if (answer and 1L == 0L && N and 1L == 1L) {
            print(answer + 1L)
        } else {
            print(answer)
        }
    }
}