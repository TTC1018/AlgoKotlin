package baekjoon.dp

private const val MINUTE = 6
private const val SECONDS_10 = 1
private const val MINUTES_10 = 60
private const val SECONDS_30 = 3

class `24390` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (M, S) = readLine().split(":").map(String::toInt)
        val total = M * MINUTE + S.div(10)

        val prev = listOf(SECONDS_10, MINUTE, MINUTES_10)
        val dp = Array(total + 1) { IntArray(2) { 1e9.toInt() } }
            .also { it[0][0] = 0; if (total >= 3) it[3][1] = 1 }

        for (sec in 1..total) {
            for (p in prev) {
                if (p <= sec) {
                    val before = sec - p
                    dp[sec][0] = minOf(dp[sec][0], dp[before][0] + 1)
                    dp[sec][1] = minOf(dp[sec][1], dp[before][0] + 2, dp[before][1] + 1)
                }
            }

            if (SECONDS_30 <= sec) {
                val before = sec - SECONDS_30
                dp[sec][1] = minOf(dp[sec][1], dp[before][1] + 1)
            }
        }

        print(dp[total][1])
    }
}

fun main() {  `24390`().solution() }