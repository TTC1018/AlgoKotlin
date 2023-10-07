package baekjoon.bruteforce

import kotlin.math.absoluteValue

class `9763` {
    private data class Point(
        val x: Int,
        val y: Int,
        val z: Int,
    )

    private fun calc(a: Point, b: Point): Int {
        return (a.x - b.x).absoluteValue + (a.y - b.y).absoluteValue + (a.z - b.z).absoluteValue
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val V = List(N) { readLine().split(" ").map(String::toInt).run { Point(this[0], this[1], this[2]) } }

        var answer = Int.MAX_VALUE
        for (center in V.indices) {
            var (t1, t2) = calc(V[center], V[(center + 1) % N]) to calc(V[center], V[(center + 2) % N])
            for (another in V.indices) {
                if (center == another)
                    continue

                val dist = calc(V[center], V[another])
                if (t1 > dist) {
                    t2 = t1
                    t1 = dist
                } else {
                    t2 = minOf(t2, dist)
                }
            }
            answer = minOf(answer, t1 + t2)
        }
        print(answer)
    }
}

fun main() {
    `9763`().solution()
}