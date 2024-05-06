package baekjoon.shortestpath

import kotlin.math.absoluteValue

private var N = 0
private var T = 0

class `16958` {
    private data class City(
        val s: Int,
        val x: Int,
        val y: Int,
    ) {
        operator fun minus(other: City) = if (s == 1 && other.s == 1) {
            minOf(T, (x - other.x).absoluteValue + (y - other.y).absoluteValue)
        } else {
            (x - other.x).absoluteValue + (y - other.y).absoluteValue
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); T = last()
        }
        val C = List(N) { readLine().split(" ").map(String::toInt).run { City(first(), this[1], last()) } }
        val D = List(N) { IntArray(N) { Int.MAX_VALUE }.apply { this[it] = 0 } }.apply {
            for (i in 0 until N) {
                for (j in i + 1 until N) {
                    val dist = C[i] - C[j]
                    this[i][j] = dist
                    this[j][i] = dist
                }
            }

            for (k in 0 until N) {
                for (i in 0 until N) {
                    for (j in 0 until N) {
                        this[i][j] = this[i][j].coerceAtMost(this[i][k] + this[k][j])
                    }
                }
            }
        }

        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val (A, B) = readLine().split(" ").map { it.toInt() - 1 }
            sb.appendLine(minOf(D[A][B], D[B][A]))
        }
        print(sb.dropLast(1))
    }
}