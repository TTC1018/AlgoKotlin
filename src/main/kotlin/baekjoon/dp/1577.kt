package baekjoon.dp

class `1577` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val K = readLine().toInt()
        val R = List(N) { BooleanArray(M + 1) { true } }
        val C = List(N + 1) { BooleanArray(M) { true } }
        repeat(K) {
            val (a, b, c, d) = readLine().split(" ").map(String::toInt)
            if (a != c) { // 세로도로
                R[minOf(a, c)][b] = false
            } else if (b != d) { // 가로도로
                C[a][minOf(b, d)] = false
            }
        }
        val dp = List(N + 1) { LongArray(M + 1) }.apply {
            this[0][0] = 1
            for (i in 1..N) {
                if (R[i - 1][0])
                    this[i][0] += this[i - 1][0]
            }
            for (j in 1..M) {
                if (C[0][j - 1])
                    this[0][j] += this[0][j - 1]
            }
        }

        for (i in 1..N) {
            for (j in 1..M) {
                if (R[i - 1][j])
                    dp[i][j] += dp[i - 1][j]
                if (C[i][j - 1])
                    dp[i][j] += dp[i][j - 1]
            }
        }
        print(dp.last().last())
    }
}