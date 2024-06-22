package baekjoon.greedy

class `21600` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt)
        val dp = IntArray(N) { 1 }
        for (i in 1 until N) {
            dp[i] = minOf(dp[i - 1] + 1, A[i])
        }
        print(dp.maxOf { it })
    }
}