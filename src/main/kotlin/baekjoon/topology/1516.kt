package baekjoon.topology

import kotlin.math.max

class `1516` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val costs = IntArray(N) { 0 }
        val graph = List(N) { mutableListOf<Int>() }
        val indegree = IntArray(N) { 0 }
        val answers = IntArray(N) { 0 }
        for (i in 0 until N){
            val costAndNexts = readLine().split(" ").map { it.toInt() }
            val cost = costAndNexts.first()
            val nexts = costAndNexts.subList(1, costAndNexts.size - 1).map { it - 1 }

            costs[i] = cost
            indegree[i] = nexts.size
            for (next in nexts){
                graph[next].add(i)
            }
        }

        val queue = ArrayDeque<Int>().apply {
            indegree.forEachIndexed { index, value ->
                if (value == 0){
                    this.add(index)
                    answers[index] = costs[index]
                }
            }
        }
        while (queue.isNotEmpty()){
            val now = queue.removeFirst()

            for (next in graph[now]){
                indegree[next]--
                answers[next] = max(answers[next], answers[now] + costs[next])

                if (indegree[next] == 0)
                    queue.addLast(next)
            }
        }

        print(answers.joinToString("\n"))
    }

}

fun main() {

    `1516`().solution()

}