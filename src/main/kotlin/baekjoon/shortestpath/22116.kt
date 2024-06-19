package baekjoon.shortestpath

import java.util.PriorityQueue
import kotlin.math.absoluteValue

class `22116` {
    private data class Route(
        val x: Int,
        val y: Int,
        val slope: Int = 0,
    )

    private val d = listOf(Route(1, 0), Route(-1, 0), Route(0, 1), Route(0, -1))

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = List(N) { readLine().split(" ").map(String::toInt) }
        val M = List(N) { IntArray(N) { Int.MAX_VALUE } }
        val q = PriorityQueue<Route>(compareBy { it.slope }).apply {
            M[0][0] = 0
            add(Route(0, 0))
        }
        while (q.isNotEmpty()) {
            val (x, y, s) = q.remove()
            if (x == N - 1 && y == N - 1) {
                print(s)
                return
            }

            d.forEach { (dx, dy) ->
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until N && ny in 0 until N) {
                    val newSlope = (A[x][y] - A[nx][ny]).absoluteValue
                    val maxVal = maxOf(s, newSlope)
                    if (maxVal < M[nx][ny]) {
                        M[nx][ny] = maxVal
                        q.add(Route(nx, ny, maxVal))
                    }
                }
            }
        }
    }
}