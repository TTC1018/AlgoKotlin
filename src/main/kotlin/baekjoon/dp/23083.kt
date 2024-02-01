package baekjoon.dp

class `23083` {
    private val MOD = 1e9.toInt() + 7

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val K = readLine().toInt()
        val B = List(N + 2) { BooleanArray(M + 1) { true } }
        repeat(K) {
            val (x, y) = readLine().split(" ").map(String::toInt)
            B[x][y] = false
        }
        val dp = List(N + 2) { LongArray(M + 1) }.apply {
            this[1][1] = 1
        }

        for (j in 1..M) {
            for (i in 1..N) {
                if (B[i][j]) {
                    dp[i][j] += if (j % 2 == 0) {
                        (dp[i - 1][j] + dp[i][j - 1] + dp[i + 1][j - 1]) % MOD
                    } else {
                        (dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1]) % MOD
                    }
                }
            }
        }
        print(dp[N][M])
    }
}
