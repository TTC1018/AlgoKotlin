package baekjoon.dp

class `11909` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val A = List(n) { readLine().split(" ").map(String::toLong) }
        val d = listOf(Loc(-1, 0), Loc(0, -1))

        val dp = List(n) { LongArray(n) { Long.MAX_VALUE } }.apply {
            this[0][0] = 0
            for (i in 1 until n) {
                this[i][0] = this[i - 1][0] + ((A[i][0] - A[i - 1][0]).coerceAtLeast(-1) + 1)
                this[0][i] = this[0][i - 1] + ((A[0][i] - A[0][i - 1]).coerceAtLeast(-1) + 1)
            }
        }
        for (i in 1 until n) {
            for (j in 1 until n) {
                for ((dx, dy) in d) {
                    val (nx, ny) = i + dx to j + dy
                    if (A[nx][ny] > A[i][j]) {
                        dp[i][j] = minOf(dp[i][j], dp[nx][ny])
                    } else {
                        val diff = A[i][j] - A[nx][ny] + 1
                        dp[i][j] = minOf(dp[i][j], dp[nx][ny] + diff)
                    }
                }
            }
        }
        print(dp.last().last())
    }
}