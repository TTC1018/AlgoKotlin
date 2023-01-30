package baekjoon.bruteforce

import java.math.BigDecimal

class `1405` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    private val dAlpha = charArrayOf('E', 'W', 'S', 'N')
    private val step = arrayOf(Pos(0, 1), Pos(0, -1), Pos(1, 0), Pos(-1, 0))
    private var N = 0
    private val p = mutableMapOf<Char, Double>()
    private var answer:Double = 0.0
    private lateinit var visited:Array<BooleanArray>
    private val inRange: (Int, Int) -> Boolean = { x, y ->
        x in 0 until 2*N + 1 && y in 0 until 2*N + 1
    }

    private fun bruteforce(x: Int, y: Int, cnt: Int, percent: Double) {
        if (cnt == N) {
            answer += percent
            return
        }

        dAlpha.forEachIndexed { i, alpha ->

            val nx = x + step[i].x
            val ny = y + step[i].y
            val newPercent = percent * p[alpha]!!

            if (inRange(nx, ny)){
                if ((visited[nx][ny]).not() && newPercent != 0.0) {
                    visited[nx][ny] = true
                    bruteforce(nx, ny, cnt + 1, newPercent)
                    visited[nx][ny] = false
                }
            }
        }

    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map { it.toDouble() }.also {
            N = it[0].toInt()
            p['E'] = it[1].div(100)
            p['W'] = it[2].div(100)
            p['S'] = it[3].div(100)
            p['N'] = it[4].div(100)
        }
        visited = Array(N * 2 + 1) { BooleanArray(N * 2 + 1) { false } }.also { it[N][N] = true }


        bruteforce(0 + N, 0 + N, 0, 1.0)

        print(BigDecimal(answer).toPlainString())
    }

}

fun main() {

    `1405`().solution()

}