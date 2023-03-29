package baekjoon.shortestpath

import kotlin.math.min

class `21278` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val graph = Array(N) { IntArray(N) { 1e9.toInt() } }
            .also { g ->
                for (i in 0 until N)
                    g[i][i] = 0

                repeat(M) {
                    val (A, B) = readLine().split(" ").map { it.toInt() - 1 }
                    g[A][B] = 1
                    g[B][A] = 1
                }
            }

        for (k in 0 until N){
            for (i in 0 until N){
                for (j in 0 until N){
                    if (graph[i][j] > graph[i][k] + graph[k][j])
                        graph[i][j] = graph[i][k] + graph[k][j]
                }
            }
        }

        var answerVal = 1e9.toInt()
        var answer = mutableListOf<Int>()
        // 조합
        for (i in 0 until N){
            for (j in i + 1 until N){
                val tmpVal = graph.sumOf { min(it[i], it[j]) * 2 }
                if (tmpVal < answerVal){
                    answer = mutableListOf(i + 1, j + 1)
                    answerVal = tmpVal
                }
            }
        }

        print("${answer.joinToString(" ")} $answerVal")
    }

}

fun main() {

    `21278`().solution()

}