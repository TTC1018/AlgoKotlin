package baekjoon.topology

import kotlin.math.max

class `2056` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val graph = List(N) { mutableListOf<Int>() }
        val indegree = IntArray(N) { 0 }
        val costs = IntArray(N) { 0 }
        val answers = IntArray(N) { 0 }

        for (i in 0 until N) {
            val costAndNexts = readLine().split(" ").map { it.toInt() }
            val cost = costAndNexts.first()
            val length = costAndNexts[1]
            val prevs = costAndNexts.drop(2).map { it - 1 }

            costs[i] = cost
            indegree[i] += length
            for (prev in prevs){
                graph[prev].add(i)
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
                    queue.addFirst(next)
            }
        }

        print(answers.maxOf { it })
    }

}

fun main() {

    `2056`().solution()

}