package baekjoon.dp

class `21555` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var N: Int
        var K: Long
        readLine().split(" ").map(String::toInt).run { N = first(); K = last().toLong() }
        val A = readLine().split(" ").map(String::toLong)
        val B = readLine().split(" ").map(String::toLong)
        val dp = List(N) { LongArray(2) { Long.MAX_VALUE } }.apply {
            this[0][0] = A[0]
            this[0][1] = B[0]
        }

        for (i in 1 until N) {
            dp[i][0] = minOf(dp[i-1][0], dp[i-1][1] + K) + A[i]
            dp[i][1] = minOf(dp[i-1][1], dp[i-1][0] + K) + B[i]
        }
        print(dp.last().minOf { it })
    }
}