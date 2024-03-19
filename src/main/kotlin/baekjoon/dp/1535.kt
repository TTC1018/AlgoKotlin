package baekjoon.dp

class `1535` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val L = readLine().split(" ").map(String::toInt)
        val J = readLine().split(" ").map(String::toInt)
        val dp = IntArray(100 + 1)
        for (i in 0 until N) {
            for (n in 100 downTo L[i]) {
                dp[n] = maxOf(dp[n], dp[n - L[i]] + J[i])
            }
        }
        print(dp[99])
    }
}