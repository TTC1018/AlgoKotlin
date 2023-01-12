package baekjoon

import kotlin.math.max

class `2573` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    private var N = 0
    private var M = 0

    private val inRange: (Int, Int) -> Boolean =
        { x, y -> x in (0 until N) && y in (0 until M) }

    private val d = listOf(
        Pos(1, 0), Pos(-1, 0),
        Pos(0, 1), Pos(0, -1)
    )

    private fun isSeperated(graph: Array<IntArray>): Boolean{
        var count = 0
        val visited = Array(N) { BooleanArray(M) { false } }

        for (i in 0 until N){
            for (j in 0 until M){
                if (graph[i][j] != 0 && visited[i][j].not()) {
                    count++
                    visited[i][j] = true
                    val q = ArrayDeque<Pos>().apply { add(Pos(i, j)) }
                    while (q.isNotEmpty()){
                        val now = q.removeFirst()

                        d.forEach { (dx, dy) ->
                            val nx = now.x + dx
                            val ny = now.y + dy
                            if (inRange(nx, ny) && visited[nx][ny].not()) {
                                if (graph[nx][ny] != 0){
                                    visited[nx][ny] = true
                                    q.add(Pos(nx, ny))
                                }
                            }
                        }
                    }
                }
            }
        }
        return count > 1
    }

    private fun isFinished(graph: Array<IntArray>): Boolean {

        for (i in 0 until N){
            for(j in 0 until M){
                if (graph[i][j] != 0)
                    return false
            }
        }

        return true
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }.also {
            N = it.first()
            M = it.last()
        }
        val graph = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }

        var time = 0
        while (isSeperated(graph).not() && isFinished(graph).not()) {

            // 얼마나 녹을지 기록
            val countGraph = Array(N) { IntArray(M) { 0 } }
            for (i in 0 until N) {
                for (j in 0 until M) {
                    if (graph[i][j] != 0) {
                        d.forEach { (dx, dy) ->
                            val nx = i + dx
                            val ny = j + dy
                            if (inRange(nx, ny) && graph[nx][ny] == 0){
                                countGraph[i][j]++
                            }
                        }
                    }
                }
            }

            // 정산
            for (i in 0 until N){
                for (j in 0 until M){
                    graph[i][j] = max(0, graph[i][j] - countGraph[i][j])
                }
            }

            time++
        }

        if (isFinished(graph) && isSeperated(graph).not())
            print(0)
        else
            print(time)

    }

}

fun main() {

    `2573`().solution()

}