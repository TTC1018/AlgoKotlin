package baekjoon.disjointset

class `16957` {
    private var R = 0
    private var C = 0
    private lateinit var next: List<IntArray>

    private data class Loc(
        val x: Int,
        val y: Int
    )

    private val d = listOf(
        Loc(-1, -1), Loc(-1, 0), Loc(-1, 1),
        Loc(0, -1), Loc(0, 1),
        Loc(1, -1), Loc(1, 0), Loc(1, 1)
    )

    private fun findDestination(nextNum: Int): Int {
        val (x, y) = nextNum / C to nextNum % C
        if (next[x][y] != x * C + y)
            next[x][y] = findDestination(next[x][y])
        return next[x][y]
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run { R = first(); C = last() }
        val B = List(R) { readLine().split(" ").map(String::toInt).toIntArray() }

        next = List(R) { IntArray(C) { -1 } }
        repeat(R) { i ->
            repeat(C) { j ->
                d.minBy { (dx, dy) ->
                    if (i + dx in 0 until R && j + dy in 0 until C) {
                        B[i + dx][j + dy]
                    } else {
                        Int.MAX_VALUE
                    }
                }
                    .takeIf { (dx, dy) -> B[i + dx][j + dy] <= B[i][j] }
                    ?.let { (dx, dy) -> next[i][j] = (i + dx) * C + (j + dy) }
                    ?: run { next[i][j] = i * C + j }
            }
        }

        val answer = List(R) { IntArray(C) }
        repeat(R) { i ->
            repeat(C) { j ->
                val destination = findDestination(i * C + j)
                val (dx, dy) = destination / C to destination % C
                answer[dx][dy]++
            }
        }
        print(answer.joinToString("\n") { it.joinToString(" ") })
    }
}

fun main() {
    `16957`().solution()
}