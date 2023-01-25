package baekjoon.shortestpath

import kotlin.math.max
import kotlin.math.min

class `2660` {

    private var N = 0

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        val graph = Array(N) { IntArray(N) { 1e9.toInt() } }.also {
            for (i in 0 until N) {
                it[i][i] = 0
            }
        }

        while (true) {

            val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
            if (a == -2 && b == -2)
                break

            graph[a][b] = 1
            graph[b][a] = 1

        }

        for (k in 0 until N){
            for (i in 0 until N){
                for (j in 0 until N){
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
                }
            }
        }

        val score = IntArray(N) { 0 }
        for (i in 0 until N){
            for (j in 0 until N){
                score[i] = max(score[i], graph[i][j])
            }
        }

        var answer = mutableListOf<Int>()
        var minVal = 1e9.toInt()
        score.forEachIndexed { i, v ->
            if (minVal == v)
                answer.add(i + 1)
            else if (minVal > v){
                minVal = v
                answer = mutableListOf(i + 1)
            }
        }

        print("$minVal ${answer.size}\n${answer.joinToString(" ")}")
    }

}

fun main() {

    `2660`().solution()

}