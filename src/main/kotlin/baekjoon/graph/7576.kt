package baekjoon.graph

import kotlin.system.exitProcess

class `7576` {

    private data class Loc(
        val x: Int,
        val y: Int
    )

    private var M = 0
    private var N = 0
    private lateinit var B: Array<IntArray>
    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))

    private fun isFinished(): Boolean {
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (B[i][j] == 0)
                    return false
            }
        }
        return true
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        var q = mutableListOf<Loc>()
        readLine().split(" ").map(String::toInt)
            .also { M = it[0]; N = it[1] }
        B = Array(N) { i ->
            readLine().split(" ").map(String::toInt).toIntArray()
                .also { for (j in 0 until M) if (it[j] == 1) q.add(Loc(i, j)) }
        }

        var answer = 0
        while (q.isNotEmpty()) {
            if (isFinished()) {
                print(answer)
                exitProcess(0)
            }

            val next = mutableListOf<Loc>()
            for ((x, y) in q) {
                for ((dx, dy) in d) {
                    val (nx, ny) = listOf(x + dx, y + dy)

                    if (nx in 0 until N && ny in 0 until M) {
                        if (B[nx][ny] == 0) {
                            B[nx][ny] = 1
                            next.add(Loc(nx, ny))
                        }
                    }
                }
            }
            q = next

            answer++
        }
        print(-1)
    }

}

fun main() {

    `7576`().solution()

}