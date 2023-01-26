package baekjoon.shortestpath

import java.util.PriorityQueue
import kotlin.math.max

class `14938` {

    data class Info(
        val now:Int,
        val total:Int
    ):Comparable<Info> {
        override fun compareTo(other: Info): Int =
            this.total.compareTo(other.total)
    }

    data class Edge(
        val next:Int,
        val cost:Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val (n, m, r) = readLine().split(" ").map { it.toInt() }
        val t = readLine().split(" ").map { it.toInt() }
        val graph = Array(n) { mutableListOf<Edge>() }
        repeat(r) {
            val (a, b, l) = readLine().split(" ").map { it.toInt() }
            graph[a - 1].add(Edge(b - 1, l))
            graph[b - 1].add(Edge(a - 1, l))
        }

        var answer = 0
        for (start in 0 until n){
            val dist = IntArray(n) { Int.MAX_VALUE }.also { it[start] = 0 }

            val q = PriorityQueue<Info>().apply { add(Info(start, 0)) }
            while (q.isNotEmpty()){
                val (now, total) = q.remove()
                if (dist[now] < total)
                    continue

                for ((next, cost) in graph[now]){
                    val newCost = total + cost
                    if (newCost < dist[next]) {
                        dist[next] = newCost
                        q.add(Info(next, newCost))
                    }
                }
            }

            answer = max(answer, t.filterIndexed { i, v -> dist[i] <= m }.sumOf { it })
        }
        print(answer)
    }

}

fun main() {

    `14938`().solution()

}