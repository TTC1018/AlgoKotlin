package baekjoon.graph

import kotlin.math.min

class `4485` {

    data class Pos(
        val x: Int,
        val y: Int,
        val r: Int
    )

    private val dx = listOf(-1, 1, 0, 0)
    private val dy = listOf(0, 0, -1, 1)

    fun solution() = with(System.`in`.bufferedReader()) {


        var order = 0
        while (true) {
            val T = readLine().toInt()
            if (T == 0)
                return

            order++
            var answer = Int.MAX_VALUE
            val cave = Array(T) { readLine().split(" ").map { it.toInt() }.toIntArray() }
            val score = Array(T) { IntArray(T) { Int.MAX_VALUE } }

            val q = ArrayDeque<Pos>().apply { add(Pos(0, 0, cave[0][0])) }
            score[0][0] = cave[0][0]
            while (q.isNotEmpty()) {
                val (qx, qy, r) = q.removeFirst()
                if (qx == T - 1 && qy == T - 1) {
                    answer = min(answer, r)
                    continue
                }

                for (i in dx.indices) {
                    val nx = qx + dx[i]
                    val ny = qy + dy[i]

                    if (nx in 0 until T && ny in 0 until T) {
                        val newScore = r + cave[nx][ny]
                        if (newScore < score[nx][ny]) {
                            score[nx][ny] = newScore
                            q.add(Pos(nx, ny, newScore))
                        }
                    }
                }
            }

            println("Problem $order: $answer")
        }

    }

}

fun main() {

    `4485`().solution()

}