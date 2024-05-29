package baekjoon.dp

class `31670` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val R = readLine().split(" ").map(String::toLong)
        val dp = List(N) { LongArray(2) }.apply {
            this[0][0] = 0
            this[0][1] = R.first()
        }
        for (i in 1 until N) {
            dp[i][0] = dp[i - 1][1]
            dp[i][1] = dp[i - 1].minOf { it } + R[i]
        }
        print(dp.last().minOf { it })
    }
}