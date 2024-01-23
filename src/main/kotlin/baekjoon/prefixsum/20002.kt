package baekjoon.prefixsum

class `20002` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        val P = List(N + 1) { IntArray(N + 1) }.apply {
            this[1][1] = B[0][0]
            for (i in 2..N) {
                this[i][1] += (this[i - 1][1] + B[i - 1][0])
                this[1][i] += (this[1][i - 1] + B[0][i - 1])
            }
            for (i in 2..N) {
                for (j in 2..N) {
                    this[i][j] += (this[i-1][j] + this[i][j-1] - this[i-1][j-1] + B[i-1][j-1])
                }
            }
        }

        var answer = Int.MIN_VALUE
        for (k in 1..N) {
            for (i in k..N) {
                for (j in k..N) {
                    answer = maxOf(answer, P[i][j] - P[i-k][j] - P[i][j-k] + P[i-k][j-k])
                }
            }
        }
        print(answer)
    }
}