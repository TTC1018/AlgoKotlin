package baekjoon.dp

class `25170` {

    private data class Loc(
        val x: Int,
        val y: Int
    )

    private var N = 0
    private var M = 0
    private var T = 0
    private lateinit var w: Array<IntArray>
    private lateinit var t: Array<IntArray>
    private lateinit var dp: Array<Array<IntArray>>
    private val d = listOf(Loc(-1, 0), Loc(0, -1), Loc(-1, -1))

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map(String::toInt)
            .also { N = it[0]; M = it[1]; T = it[2] }
        w = Array(N) { readLine().split(" ").map(String::toInt).toIntArray() }
        t = Array(N) { readLine().split(" ").map(String::toInt).toIntArray() }
        dp = Array(N + 1) { Array(M + 1) { IntArray(T + 1) { -1 } } }
            .apply { this[1][1][0] = 0 }

        for (i in 1..N) {
            for (j in 1..M) {
                if (i == 1 && j == 1)
                    continue

                for (time in 1..T) {
                    dp[i][j][time] =
                        maxOf(
                            dp[i - 1][j][time - 1],
                            dp[i][j - 1][time - 1],
                            dp[i - 1][j - 1][time - 1]
                        )

                    val prev = time - (t[i - 1][j - 1] + 1)
                    if (prev >= 0) {
                        d.filter { (x, y) -> (i + x) in 0 .. N && (j + y) in 0 .. M && dp[i + x][j + y][prev] != -1 }
                            .map { (x, y) -> dp[i + x][j + y][prev] }
                            .maxOfOrNull { it }
                            .also { if (it != null) dp[i][j][time] = maxOf(dp[i][j][time], it + w[i - 1][j - 1]) }
                    }
                }
            }
        }

        print(dp[N][M].maxOf { it })
    }

}

fun main() {

    `25170`().solution()

}