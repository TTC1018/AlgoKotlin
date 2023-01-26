package baekjoon.graph

import kotlin.math.sqrt

class `1686` {

    private var v = 0f
    private var m = 0f

        private fun calcDist(a: Float, b: Float, x: Float, y: Float): Float {
        return sqrt(((a - x) * (a - x) + (b - y) * (b - y)))
    }

    data class Pos(
        val x: Float,
        val y: Float,
        val cnt: Int = 0
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().trim().split(" ").map { it.toFloat() }.also {
            v = it.first()
            m = it.last()
        }

        val stepRange = (v * 60 * m)
        val (xs, ys) = readLine().trim().split(" ").map { it.toFloat() }
        val (xt, yt) = readLine().trim().split(" ").map { it.toFloat() }
        val bunkers = mutableSetOf<Pos>()

        while (true) {

            val input = readLine()
            if (input.isNullOrEmpty())
                break

            val (x, y) = input.trim().split(" ").map { it.toFloat() }
            bunkers.add(Pos(x, y))

        }

        val visited = mutableSetOf(Pos(xs, ys))
        val q = ArrayDeque<Pos>().apply { add(Pos(xs, ys)) }
        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (calcDist(x, y, xt, yt) < stepRange){
                print("Yes, visiting $cnt other holes.")
                return
            }

            for (bunker in bunkers){
                if ((bunker in visited).not() && calcDist(x, y, bunker.x, bunker.y) < stepRange){
                    visited.add(bunker)
                    q.add(Pos(bunker.x, bunker.y, cnt + 1))
                }
            }
        }

        print("No.")
    }

}

fun main() {

    `1686`().solution()

}