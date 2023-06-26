package baekjoon.dp

class `17218` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val A = readLine()
        val B = readLine()
        val dp = Array(A.length+1) { IntArray(B.length+1) }
        for (i in 1..A.length) {
            for (j in 1..B.length) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                }
                else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        var maxVal = dp[A.length][B.length]
        var (r, c) = listOf(A.length, B.length)

        val answer = StringBuilder()
        while (maxVal > 0) {
            when {
                dp[r - 1][c] == maxVal -> r--
                dp[r][c - 1] == maxVal -> c--
                else -> { // dp[r - 1][c - 1] + 1 == dp[r][c] 가 된 경우 (A[r] == B[c]인 경우)
                    maxVal--
                    r--
                    c--
                    answer.append(A[r])
                }
            }
        }
        print(answer.reverse())
    }
}

fun main() { `17218`().solution() }