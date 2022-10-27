package baekjoon

import kotlin.math.min

class `16926` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M, R) = readLine().split(" ").map { it.toInt() }
        var graph = List(N) { readLine().split(" ").map { it.toInt() } }

        repeat(R) {
            val nextGraph = List(N) { MutableList(M) { 0 } }
            for (x in 0 until min(N, M).div(2)){
                // 상
                for (y in M - x - 1 downTo  x + 1){
                    nextGraph[x][y - 1] = graph[x][y]
                }
                // 좌
                for (nx in x until N - x - 1){
                    nextGraph[nx + 1][x] = graph[nx][x]
                }
                // 하
                for (y in x until M - x - 1){
                    nextGraph[N - x - 1][y + 1] = graph[N - x - 1][y]
                }
                // 우
                for (nx in N - x - 1 downTo x + 1){
                    nextGraph[nx - 1][M - x - 1] = graph[nx][M - x - 1]
                }
            }
            graph = nextGraph

        }

        println(graph.joinToString("\n") { it.joinToString(" ") })
    }

}

fun main() {

    `16926`().solution()

}