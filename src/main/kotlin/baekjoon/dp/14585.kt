package baekjoon.dp

class `14585` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val C = List(300 + 1) { LongArray(300 + 1) }.apply {
            repeat(N) {
                val (x, y) = readLine().split(" ").map(String::toInt)
                this[x][y] = (M - x - y).coerceAtLeast(0).toLong()
            }
        }
        val dp = List(300 + 1) { LongArray(300 + 1) }.apply {
            for (i in 1..300) {
                this[0][i] += this[0][i - 1] + C[0][i]
                this[i][0] += this[i - 1][0] + C[i][0]
            }
        }

        for (i in 1..300) {
            for (j in 1..300) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1]) + C[i][j]
            }
        }
        print(dp[300][300])
    }
}