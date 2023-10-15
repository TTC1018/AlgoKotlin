package baekjoon.dp

class `28325` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val C = readLine().split(" ").map(String::toLong)
        var dp = List(N*2) { LongArray(3) }.apply {
            this[0][1] = 1
            this[0][2] = C.first()

            this[1][0] = this[0].maxOf { it } // 자신 안 고르기
            this[1][1] = maxOf(this[0][0], this[0][2]) + 1 // 자신 고르기
            this[1][2] = this[0].maxOf { it } + C[1]
        }

        for (i in 2 until N*2) {
            // 자신 안 고르기
            dp[i][0] = dp[i - 1].maxOf { it }

            // 자신 고르기
            dp[i][1] = maxOf(dp[i - 2].maxOf { it }, dp[i - 1][0], dp[i - 1][2]) + 1

            // 쪽방 고르기
            dp[i][2] = dp[i - 1].maxOf { it } + (C[i % N])
        }

        print(dp.last().maxOf { it }.div(2))
    }
}