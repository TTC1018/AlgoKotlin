package baekjoon.dp

class `14945` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val dp = List(n + 1) { IntArray(n + 1) }.apply {
            if (n >= 2)
                this[2][1] = 2
        }
        for (i in 3..n) {
            for (j in 1 until n) {
                dp[i][j] = 2 * dp[i - 1][j] + dp[i - 1][j - 1] + dp[i - 1][j + 1]
                dp[i][j] %= 10007
            }
        }
        print(dp.last().fold(0) { acc, v -> (acc + v) % 10007 })
    }
}