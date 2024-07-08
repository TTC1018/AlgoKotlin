package baekjoon.dp

class `14863` {
    private data class Cost(
        val wt: Int,
        val wc: Int,
        val bt: Int,
        val bc: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val C = List(N) { readLine().split(" ").map(String::toInt).let { Cost(it[0], it[1], it[2], it[3]) } }
        // 특정 시간까지 최대로 모을 수 있는 돈
        val dp = List(N + 1) { IntArray(K + 1) { Int.MIN_VALUE } }.apply {
            this[0][0] = 0
        }
        for (i in 1 .. N) {
            val (wt, wc, bt, bc) = C[i - 1]
            for (t in 0..K) {
                if (wt <= t) {
                    dp[i][t] = maxOf(dp[i][t], dp[i - 1][t - wt] + wc)
                }
                if (bt <= t) {
                    dp[i][t] = maxOf(dp[i][t], dp[i - 1][t - bt] + bc)
                }
            }
        }
        print(dp.last().maxOf { it })
    }
}