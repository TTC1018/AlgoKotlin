package baekjoon.dp

class `14231` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().trim().toInt()
        val A = readLine().trim().split(" ").map(String::toInt)

        val dp = IntArray(n) { 1 }
        var answer = 1
        for (i in 1 until n) {
            for (j in 0 until i) {
                if (A[j] < A[i]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                    answer = maxOf(answer, dp[i])
                }
            }
        }
        print(answer)
    }
}