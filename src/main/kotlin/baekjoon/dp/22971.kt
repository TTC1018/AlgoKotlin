package baekjoon.dp

class `22971` {
    private val MOD = 998244353

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt)
        val dp = IntArray(N) { 1 }

        for (i in 1 until N) {
            for (j in 0 until i) {
                if (A[j] < A[i]) {
                    dp[i] += dp[j]
                    dp[i] %= MOD
                }
            }
        }
        print(dp.joinToString(" "))
    }
}