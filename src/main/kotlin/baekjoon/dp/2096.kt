package baekjoon.dp

import kotlin.math.max
import kotlin.math.min

class `2096` {

    data class Loc(
        val x: Int,
        val y: Int
    )

    private val d = listOf(Loc(-1, -1), Loc(-1, 0), Loc(-1, 1))
    private lateinit var inRange: (Int, Int) -> Boolean

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val B = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        val dp = Array(2) { Array(N) { IntArray(3) } }
            .also {
                for (i in 0..2) {
                    it[0][0][i] = B[0][i]; it[1][0][i] = B[0][i]
                }
            }
        inRange = { x, y -> x in 0 until N && y in 0..2 }

        for (r in 1 until N) {
            for (c in 0..2) {
                dp[1][r][c] = 1e9.toInt()
                for ((dx, dy) in d) {
                    val px = r + dx
                    val py = c + dy

                    if (inRange(px, py)){
                        dp[0][r][c] = max(dp[0][r][c], dp[0][px][py] + B[r][c])
                        dp[1][r][c] = min(dp[1][r][c], dp[1][px][py] + B[r][c])
                    }
                }
            }
        }

        print("${dp[0][N - 1].maxOf { it }} ${dp[1][N - 1].minOf { it }}")
    }

}

fun main() {

    `2096`().solution()

}