package baekjoon.bruteforce

import kotlin.math.absoluteValue

class `15686` {
    private data class Pos(
        val x: Int,
        val y: Int
    )
    private var N = 0
    private var M = 0
    private val H = mutableListOf<Pos>()
    private val C = mutableListOf<Pos>()
    private val chicks = mutableListOf<Pos>()
    private lateinit var visited: BooleanArray
    private var answer = Int.MAX_VALUE

    private fun bruteforce(idx: Int, cnt: Int) {
        if (cnt == M) {
            var tmpAnswer = 0
            for ((hx, hy) in H) {
                tmpAnswer += chicks.map { (cx, cy) -> (hx - cx).absoluteValue + (hy - cy).absoluteValue }.minOf { it }
            }
            answer = minOf(answer, tmpAnswer)
            return
        }

        for (i in idx until C.size) {
            if (visited[i].not()) {
                visited[i] = true
                chicks.add(C[i])
                bruteforce(i + 1, cnt + 1)
                chicks.removeLast()
                visited[i] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).also { N = it[0]; M = it[1] }
        repeat(N) { i ->
            readLine().split(" ").map(String::toInt).forEachIndexed { j, v ->
                when(v) {
                    1 -> H.add(Pos(i, j))
                    2 -> C.add(Pos(i, j))
                }
            }
        }
        visited = BooleanArray(C.size) { false }

        bruteforce(0, 0)
        print(answer)
    }
}

fun main() {
    `15686`().solution()
}