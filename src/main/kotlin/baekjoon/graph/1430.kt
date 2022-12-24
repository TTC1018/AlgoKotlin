package baekjoon.graph

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

class `1430` {

    data class Pos(
        val x: Int,
        val y: Int,
        val passed: Int
    )

    private fun calcDist(a: Int, b: Int, x: Int, y: Int): Double {
        return sqrt(((a - x) * (a - x) + (b - y) * (b - y)).toDouble())
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, R, D, X, Y) = readLine().split(" ").map { it.toInt() }
        val visited = Array(1000 + 1) { BooleanArray(1000 + 1) { false } }
        val towers = Array(1000 + 1) { BooleanArray(1000 + 1) { false } }.also { t ->
            repeat(N) {
                val (x, y) = readLine().split(" ").map { it.toInt() }
                t[x][y] = true
            }
        }

        visited[X][Y] = true
        val queue = ArrayDeque<Pos>().apply {
            add(Pos(X, Y, 0))
        }

        var answer = 0.0
        while (queue.isNotEmpty()) {
            val (x, y, passed) = queue.removeFirst()

            for (nx in max(0, x - R)..min(x + R, 1000)) {
                for (ny in max(0, y - R)..min(y + R, 1000)) {
                    if (visited[nx][ny].not() && calcDist(x, y, nx, ny) <= R) {
                        if (towers[nx][ny]) {
                            visited[nx][ny] = true
                            answer += D.toDouble() / 2.0.pow(passed)
                            queue.add(Pos(nx, ny, passed + 1))
                        }
                    }
                }
            }
        }


        print(answer)
    }

}

fun main() {

    `1430`().solution()

}