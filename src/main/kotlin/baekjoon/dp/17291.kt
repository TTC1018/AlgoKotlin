package baekjoon.dp

class `17291` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val dp = IntArray(N + 1).apply {
            this[1] = 1
            if (N >= 2)
                this[2] = 2
            if (N >= 3)
                this[3] = 4
        }
        val generated = IntArray(N + 1).apply {
            this[1] = 1
            if (N >= 2)
                this[2] = 1
            if (N >= 3)
                this[3] = 2
        }

        for (m in 4..N) {
            generated[m] = dp[m - 1]
            var left = dp[m - 1] * 2
            if ((m - 3) % 2 == 1) {
                left -= generated[m - 3]
            }

            if (m - 4 > 0 && (m - 4) % 2 == 0) {
                left -= generated[m - 4]
            }

            dp[m] = left
        }
        print(dp[N])
    }
}

fun main() {
    `17291`().solution()
}