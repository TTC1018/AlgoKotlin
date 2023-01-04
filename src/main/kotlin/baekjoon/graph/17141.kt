package baekjoon.graph

import kotlin.math.min

class `17141` {

    private var answer = Int.MAX_VALUE
    private lateinit var graph: Array<IntArray>
    private lateinit var ables: MutableList<Pos>
    private val d = listOf(
        Pos(1, 0), Pos(-1, 0),
        Pos(0, 1), Pos(0, -1)
    )

    data class Pos(
        val x: Int,
        val y: Int
    )

    private fun isFinished(graph: Array<IntArray>): Boolean {
        val len = graph.size
        for (i in 0 until len) {
            for (j in 0 until len) {
                if (graph[i][j] != 1 && graph[i][j] != 3)
                    return false
            }
        }
        return true
    }

    private fun bfs(cands: Set<Int>){

        var result = 0
        val graphCpy = graph.map { it.clone() }.toTypedArray()
        val N = graph.size
        var q = ArrayDeque<Pos>()

        cands.forEach { idx ->
            val (x, y) = ables[idx]
            graphCpy[x][y] = 3
            q.add(ables[idx])
        }

        while (q.isNotEmpty() && isFinished(graphCpy).not()) {

            val nxt = ArrayDeque<Pos>()
            q.forEach { (x, y) ->
                d.forEach { (dx, dy) ->
                    val nx = x + dx
                    val ny = y + dy

                    if (nx in 0 until N && ny in 0 until N){
                        if (graphCpy[nx][ny] != 1 && graphCpy[nx][ny] != 3){
                            graphCpy[nx][ny] = 3
                            nxt.add(Pos(nx, ny))
                        }
                    }
                }
            }

            q = nxt
            result++
        }

        if (isFinished(graphCpy))
            answer = min(answer, result)
    }

    private fun bruteforce(now: Int, cands: Set<Int>, count: Int, limit: Int) {

        if (count == limit) {
            bfs(cands)
            return
        }


        for (i in now until ables.size) {
            bruteforce(i + 1, cands + setOf(i), count + 1, limit)
        }

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        graph = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        ables = mutableListOf<Pos>().apply {
            graph.forEachIndexed { i, row ->
                row.forEachIndexed { j, value ->
                    if (value == 2)
                        add(Pos(i, j))
                }
            }
        }

        bruteforce(0, setOf(), 0, M)

        if (answer != Int.MAX_VALUE)
            println(answer)
        else
            println(-1)
    }

}

fun main() {

    `17141`().solution()

}