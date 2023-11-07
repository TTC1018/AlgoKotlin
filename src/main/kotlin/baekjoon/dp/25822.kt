package baekjoon.dp

class `25822` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val C = readLine().toDouble()
        val N = readLine().toInt()
        val Q = readLine().split(" ").map(String::toInt)
        val limit = minOf(C.div(0.99).toInt(), 2)
        val dp = List(N) { IntArray(limit+1) }.apply {
            if (Q.first() > 0)
                this[0][0] = 1
            else if (C >= 0.99)
                this[0][1] = 1

        }

        var maxDay = 1
        var maxVal = Q.first()
        for (i in 1 until N) {
            if (Q[i] > 0) {
                for (j in 0 .. limit) {
                    dp[i][j] = dp[i-1][j] + 1
                    maxDay = maxOf(maxDay, dp[i][j])
                }
            } else {
                for (j in 1 .. limit) {
                    dp[i][j] = dp[i-1][j-1] + 1
                    maxDay = maxOf(maxDay, dp[i][j])
                }
            }
            maxVal = maxOf(Q[i], maxVal)
        }
        print("$maxDay\n$maxVal")
    }
}