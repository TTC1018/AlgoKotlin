package baekjoon.dp

class `1757` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val D = List(N) { readLine().toInt() }
        val dp = List(N) { IntArray(M + 1) }.apply {
            this[0][1] = D.first()
        }
        // 1분 동안 D[i]만큼 달림
        // 1분 달리면 지침 지수 1 증가, M이 되면 더이상 달리지 못함
        // 고로 M에 도달하면 M분 동안 쉬고 나서 달리기 가능
        for (i in 1 until N) {
            dp[i][0] = dp[i - 1][0]
            // 1분 전의 경우 + 현재
            for (j in 1..M) {
                dp[i][j] = dp[i - 1][j - 1] + D[i]
            }

            // j분 전의 경우에서 완전히 회복
            for (j in 1 .. minOf(M, i)) {
                dp[i][0] = maxOf(dp[i][0], dp[i - j][j])
            }
        }
        print(dp.last().first())
    }
}