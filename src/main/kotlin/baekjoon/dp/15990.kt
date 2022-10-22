package baekjoon.dp

class `15990` {

    private val MOD = 1000000009L

    fun solution() = with(System.`in`.bufferedReader()) {

        val T = readLine().toInt()
        val dp = Array(100000 + 1) { Array(3 + 1) { 0L } }
        dp[1][1] = 1L; dp[2][2] = 1L; dp[3][1] = 1L
        dp[3][2] = 1L; dp[3][3] = 1L

        var maxIdx = 3
        for (order in 1..T) {

            val n = readLine().toInt()
            if (maxIdx >= n) {
                println(dp[n].sumOf { it } % MOD)
                continue
            }

            for (i in (maxIdx + 1)..n) {
                for (j in 1..3) {
                    val firstIdx = if (j - 1 > 0) j - 1 else 3
                    val secondIdx = if (j - 2 > 0) j - 2 else (j - 2) + 3
                    dp[i][j] = (dp[i - j][firstIdx] + dp[i - j][secondIdx]) % MOD
                }
            }
            println(dp[n].sumOf { it } % MOD)
            maxIdx = n
        }

    }

}

fun main() {

    `15990`().solution()

}