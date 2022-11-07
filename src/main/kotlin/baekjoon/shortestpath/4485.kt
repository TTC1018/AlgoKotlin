package baekjoon.shortestpath

import java.util.PriorityQueue

class `4485` {

    data class Pos(
        val x: Int,
        val y: Int,
        val r: Int
    ) : Comparable<Pos> {
        override fun compareTo(other: Pos): Int {
            return this.r.compareTo(other.r)
        }
    }

    private val dx = listOf(-1, 1, 0, 0)
    private val dy = listOf(0, 0, -1, 1)

    fun solution() = with(System.`in`.bufferedReader()) {

        var order = 0
        while (true) {
            val n = readLine().toInt()
            if (n == 0)
                return

            order++
            val cave = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
            val pq = PriorityQueue<Pos>().apply { add(Pos(0, 0, cave[0][0])) }
            val dist = Array(n) { IntArray(n) { Int.MAX_VALUE } }
            dist[0][0] = 0

            while (pq.isNotEmpty()) {
                val (qx, qy, r) = pq.remove()
                if (qx == n - 1 && qy == n - 1) {
                    println("Problem $order: ${dist[qx][qy]}")
                    break
                }

                for (i in dx.indices) {
                    val nx = qx + dx[i]
                    val ny = qy + dy[i]

                    if (nx in 0 until n && ny in 0 until n) {
                        val newScore = r + cave[nx][ny]
                        if (newScore < dist[nx][ny]) {
                            dist[nx][ny] = newScore
                            pq.add(Pos(nx, ny, newScore))
                        }
                    }
                }
            }
        }
    }

}

fun main() {

    `4485`().solution()

}