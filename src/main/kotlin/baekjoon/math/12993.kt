package baekjoon.math

import kotlin.math.pow

class `12993` {
    private data class Pos(
        val x: Double,
        val y: Double,
        val step: Int = 0,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (tx, ty) = readLine().split(" ").map(String::toDouble)
        val V = mutableSetOf<Pos>()
        val q = ArrayDeque<Pos>().apply { add(Pos(0.0, 0.0)) }
        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (x == tx && y == ty) {
                print(1)
                return
            }

            val next = (3.0).pow(cnt)
            val up = Pos(x, y + next, cnt + 1)
            val right = Pos(x + next, y, cnt + 1)
            if (y + next <= ty && up !in V) {
                V.add(up)
                q.add(up)
            }
            if (x + next <= tx && right !in V) {
                V.add(right)
                q.add(right)
            }
        }
        println(V.size)
        print(0)
    }
}