package baekjoon.dp

class `2418` {
    private data class Step(
        val x: Int,
        val y: Int,
    )

    private val d = listOf(
        Step(-1, -1), Step(-1, 0), Step(-1, 1),
        Step(0, -1), Step(0, 1),
        Step(1, -1), Step(1, 0), Step(1, 1),
    )

    private var H = 0
    private var W = 0
    private var L = 0
    private lateinit var B: List<String>
    private lateinit var S: String
    private lateinit var dp: List<List<LongArray>>

    private fun dfs(x: Int, y: Int, cnt: Int): Long {
        if (dp[x][y][cnt] != -1L)
            return dp[x][y][cnt]

        dp[x][y][cnt] = 0
        if (B[x][y] == S.last() && cnt == L) {
            dp[x][y][cnt] = 1
        } else {
            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until H && ny in 0 until W) {
                    if (B[nx][ny] == S[cnt])
                        dp[x][y][cnt] += dfs(nx, ny, cnt + 1)
                }
            }
        }
        return dp[x][y][cnt]
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            H = first(); W = this[1]; L = last()
        }
        B = List(H) { readLine() }
        S = readLine()
        dp = List(H) { List(W) { LongArray(L + 1) { -1 } } }

        var answer = 0L
        for (i in 0 until H) {
            for (j in 0 until W) {
                if (B[i][j] == S.first()) {
                    answer += dfs(i, j, 1)
                }
            }
        }
        print(answer)
    }
}