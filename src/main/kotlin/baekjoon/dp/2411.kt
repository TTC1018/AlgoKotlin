package baekjoon.dp

class `2411` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    private var N = 0
    private var M = 0
    private var A = 0
    private var B = 0
    private lateinit var board: Array<IntArray>
    private lateinit var dp: Array<IntArray>
    private val items = mutableListOf<Pos>()

    private fun input() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map { it.toInt() }
            .also { N = it[0]; M = it[1]; A = it[2]; B = it[3] }
        board = Array(N + 1) { IntArray(M + 1) }
        dp = Array(N + 1) { IntArray(M + 1) }

        repeat(A) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            board[x][y] = 1
            items.add(Pos(x, y))
        }
        items.sortWith(compareBy({it.y}, {it.x}))
        items.add(Pos(N, M))

        repeat(B) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            board[x][y] = -1
        }
    }

    fun solution() = with(System.out.bufferedWriter()) {

        input()

        dp[1][0] = 1 // 시작점 초기값 (1열에 다 전파되도록 0열에 초기화)
        // 이동 가능한 방향 = 오른쪽 or 아래
        // 내 자리로 올 수 있는 방향 = 왼쪽 or 위
        var now = Pos(1, 1)
        for ((ix, iy) in items){
            val (sx, sy) = now
            for (i in sx..ix){
                for (j in sy..iy){
                    if (board[i][j] != - 1)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
            now = Pos(ix, iy)
        }

        write(dp[N][M].toString())
        flush()
    }

}

fun main() {

    `2411`().solution()

}