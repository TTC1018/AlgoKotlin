package baekjoon.dp

class `9252` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val A = readLine()
        val B = readLine()

        val dp = List(A.length + 1) { IntArray(B.length + 1) { 0 } }.apply {
            for (i in 1..A.length) {
                this[i][1] = 1
            }
            for (i in 1..B.length) {
                this[1][i] = 1
            }
        }

        for (i in 1..A.length) {
            for (j in 1..B.length) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        val sb = StringBuilder()
        var (x, y) = A.length to B.length
        while (dp[x][y] > 0) {
            if (A[x-1] == B[y-1]) {
                sb.append(A[x-1])
                x--; y--
            } else {
                if (dp[x-1][y] > dp[x][y-1]) {
                    x--
                } else {
                    y--
                }
            }
        }
        sb.reverse()
        print("${sb.length}\n$sb")
    }
}