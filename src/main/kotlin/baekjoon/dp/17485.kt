package baekjoon.dp

class `17485` {
    private data class Direc(
            val x: Int,
            val y: Int,
    )

    private val d = listOf(
            Direc(-1, -1), Direc(-1, 0), Direc(-1, 1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        // 이전 방향에서 똑같이 올 수 없음
        val dp = List(N) { List(M) { IntArray(3) { Int.MAX_VALUE } } }.apply {
            for (j in 0 until M) {
                for (dIdx in 0..2) {
                    this[0][j][dIdx] = B[0][j]
                }
            }
        }

        for (i in 1 until N) {
            for (j in 0 until M) {
                for (dIdx in 0..2) {
                    for (prevD in 0..2) {
                        if (dIdx != prevD) {
                            val (px, py) = i + d[prevD].x to j + d[prevD].y
                            if (px in 0 until N && py in 0 until M) {
                                dp[i][j][dIdx] = minOf(dp[i][j][dIdx], dp[px][py][prevD] + B[i][j])
                            }
                        }
                    }
                }
            }
        }
        print(dp.last().minOf { row -> row.minOf { it } })
    }
}