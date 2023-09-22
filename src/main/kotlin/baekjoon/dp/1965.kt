package baekjoon.dp

class `1965` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val B = readLine().split(" ").map(String::toInt)

        val dp = IntArray(n) { 1 }
        var answer = 1
        for (i in 1 until n) {
            for (j in 0 until i) {
                if (B[j] < B[i]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                    answer = maxOf(answer, dp[i])
                }
            }
        }
        print(answer)
    }
}

fun main() {
    `1965`().solution()
}