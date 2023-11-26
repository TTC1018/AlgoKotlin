package baekjoon.dp

class `20167` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val B = readLine().split(" ").map(String::toInt)
        val dp = IntArray(N+1)
        var (l, r) = 0 to 1
        var sumVal = B.first()
        while (r <= N) {
            if (sumVal >= K) {
                while (sumVal >= K) {
                    dp[r] = maxOf(dp[r], sumVal - K + dp[l])
                    sumVal -= B[l++]
                }
            } else {
                dp[r] = maxOf(dp[r], dp[r - 1])
                r.takeIf { it < N }
                    ?.let { sumVal += B[it] }
                r++
            }
        }
        print(dp.last())
    }
}