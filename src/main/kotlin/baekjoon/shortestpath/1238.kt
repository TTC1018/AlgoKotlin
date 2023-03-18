package baekjoon.shortestpath

import java.util.PriorityQueue

class `1238` {

    data class Edge(
        val now: Int,
        val dist: Int
    ):Comparable<Edge> {
        override fun compareTo(other: Edge) = dist.compareTo(other.dist)
    }

    private var N = 0
    private var M = 0
    private var X = 0
    private lateinit var roads: Array<MutableList<Edge>>
    private lateinit var xToOther: IntArray
    private lateinit var distToX: IntArray

    private fun dijkstra(num: Int): Int{
        val pq = PriorityQueue<Edge>().apply { add(Edge(num, 0)) }
        val distance = IntArray(N) { 1e9.toInt() }.also { it[num] = 0 }

        while (pq.isNotEmpty()){
            val (now, dist) = pq.remove()
            if (now == X){
                return dist
            }

            if (distance[now] < dist)
                continue

            for ((nxt, cost) in roads[now]){
                val newDist = cost + dist
                if (newDist < distance[nxt]){
                    distance[nxt] = newDist
                    pq.add(Edge(nxt, newDist))
                }
            }
        }
        return 1e9.toInt()
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { N = it[0]; M = it[1]; X = it[2] - 1 }

        roads = Array(N) { mutableListOf() }
        repeat(M) {
            val (s, e, c) = readLine().split(" ").map { it.toInt() - 1 }
            roads[s].add(Edge(e, c + 1))
        }

        xToOther = IntArray(N) { 1e9.toInt() }.also {
            it[X] = 0
            val pq = PriorityQueue<Edge>().apply { add(Edge(X, 0)) }

            while (pq.isNotEmpty()){
                val (now, dist) = pq.remove()

                if (it[now] < dist)
                    continue

                for ((nxt, cost) in roads[now]){
                    val newDist = dist + cost
                    if (newDist < it[nxt]) {
                        it[nxt] = newDist
                        pq.add(Edge(nxt, newDist))
                    }
                }
            }
        }

        distToX = IntArray(N) { 1e9.toInt() }.also { it[X] = 0 }
        for (i in 0 until N) {
            if (i == X)
                continue
            distToX[i] = dijkstra(i)
        }


        print(distToX.zip(xToOther).maxOf { it.first + it.second })
    }

}

fun main() {

    `1238`().solution()

}