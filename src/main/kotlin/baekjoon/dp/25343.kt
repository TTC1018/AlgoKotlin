package baekjoon.dp

class `25343` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        val dp = List(N) { IntArray(N) { 1 } }.apply {
            for (i in 1 until N) {
                for (j in 0 until i) {
                    if (B[0][j] < B[0][i])
                        this[0][i] = maxOf(this[0][i], this[0][j] + 1)
                    if (B[j][0] < B[i][0])
                        this[i][0] = maxOf(this[i][0], this[j][0] + 1)
                }
            }
        }

        var answer = 1
        for (x in 1 until N) {
            for (y in 1 until N) {
                for (i in 0..x) {
                    for (j in 0..y) {
                        if (B[i][j] < B[x][y]) {
                            dp[x][y] = maxOf(dp[x][y], dp[i][j] + 1)
                            answer = maxOf(answer, dp[x][y])
                        }
                    }
                }
            }
        }
        print(answer)
    }
}