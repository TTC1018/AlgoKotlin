package baekjoon.dp

class `13302` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val D = buildSet {
            if (M != 0) {
                addAll(readLine().split(" ").map(String::toInt))
            }
        }
        val dp = List(N + 1) { IntArray((N.floorDiv(2)) * 2 + 1) { 1e9.toInt() } }.apply {
            this[0][0] = 0
        }
        for (n in 0..N) {
            for (c in 0 until dp[n].size) {
                dp[n][c].takeIf { it != 1e9.toInt() }?.let { now ->
                    if (n + 1 in D) {
                        dp[n + 1][c] = minOf(now, dp[n + 1][c])
                    }
                    if (c >= 3) {
                        dp.getOrNull(n + 1)?.getOrNull(c - 3)?.run {
                            dp[n + 1][c - 3] = minOf(now, dp[n + 1][c - 3])
                        }
                    }

                    dp.getOrNull(n + 1)?.getOrNull(c)?.run {
                        dp[n + 1][c] = minOf(now + 1e4.toInt(), dp[n + 1][c])
                    }
                    (1..3).forEach {
                        dp.getOrNull(n + it)?.getOrNull(c + 1)?.run {
                            dp[n + it][c + 1] = minOf(now + 25000, dp[n + it][c + 1])
                        }
                    }
                    (1..5).forEach {
                        dp.getOrNull(n + it)?.getOrNull(c + 2)?.run {
                            dp[n + it][c + 2] = minOf(now + 37000, dp[n + it][c + 2])
                        }
                    }
                }
            }
        }
        print(dp.last().minOf { it })
    }
}