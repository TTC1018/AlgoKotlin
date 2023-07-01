package baekjoon.dp

class `22857` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var answer = 0
        val (N, K) = readLine().split(" ").map(String::toInt)
        val S = readLine().split(" ").map(String::toInt).toIntArray()
        val dp = Array(N) { IntArray(K + 1) }
            .also {
                if (S[0] % 2 == 0) {
                    answer = 1
                    it[0][0] = 1
                }
            }

        for (i in 1 until N) {
            if (S[i] % 2 == 0) {
                dp[i][0] = 1
                for (cnt in 0..K) {
                    dp[i][cnt] = maxOf(dp[i][cnt], dp[i - 1][cnt] + 1)
                }
            } else {
                for (cnt in 1..K) {
                    dp[i][cnt] = maxOf(dp[i][cnt], dp[i - 1][cnt - 1])
                }
            }
            answer = maxOf(answer, dp[i].maxOf { it })
        }
        print(answer)
    }
}

fun main() {
    `22857`().solution()
}