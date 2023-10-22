package baekjoon.dp

class `15645` {
    private data class Step(
        val x: Int,
        val y: Int,
    )

    private val d = listOf(
        Step(-1, 0), Step(-1, -1), Step(-1, 1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        val dp = List(N) { List(3) { intArrayOf(900000, 0) } }.apply {
            this[0][0][0] = B[0][0]
            this[0][0][1] = B[0][0]
            this[0][1][0] = B[0][1]
            this[0][1][1] = B[0][1]
            this[0][2][0] = B[0][2]
            this[0][2][1] = B[0][2]
        }

        for (r in 1 until N) {
            for (c in 0 until 3) {
                for ((dx, dy) in d) {
                    val (nx, ny) = r + dx to c + dy
                    if (nx in 0 until N && ny in 0 until 3) {
                        dp[r][c][0] = minOf(dp[r][c][0], dp[nx][ny][0] + B[r][c])
                        dp[r][c][1] = maxOf(dp[r][c][1], dp[nx][ny][1] + B[r][c])
                    }
                }
            }
        }
        print("${dp[N - 1].maxOf { c -> c.maxOf { it } }} ${dp[N - 1].minOf { c -> c.minOf { it } }}")
    }
}