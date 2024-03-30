package baekjoon.bruteforce

import kotlin.math.absoluteValue

class `10655` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val L = List(N) { readLine().split(" ").map(String::toInt).run { Loc(first(), last()) } }
        val D = L.zipWithNext { a, b -> (a.x - b.x).absoluteValue + (a.y - b.y).absoluteValue }
        val total = D.sumOf { it }
        var answer = Int.MAX_VALUE
        for (i in 1 until D.size - 1) {
            answer = minOf(
                answer,
                total - (D[i - 1] + D[i])
                        + (L[i - 1].x - L[i + 1].x).absoluteValue
                        + (L[i - 1].y - L[i + 1].y).absoluteValue
            )
        }
        print(answer)
    }
}