package baekjoon.shortestpath

import java.util.PriorityQueue

class `1504` {
    private data class Edge(
        val next: Int,
        val c: Long,
    ): Comparable<Edge> {
        override fun compareTo(other: Edge): Int =
            c.compareTo(other.c)
    }

    private var N = 0
    private var E = 0
    private lateinit var G: List<MutableList<Edge>>
    private var v1 = 0
    private var v2 = 0

    private fun dijk(start: Int): LongArray {
        val pq = PriorityQueue<Edge>().apply {
            add(Edge(start, 0))
        }
        val dist = LongArray(N) { Int.MAX_VALUE.toLong() }.apply {
            this[start] = 0
        }
        while (pq.isNotEmpty()) {
            val (now, c) = pq.remove()

            for ((next, nextC) in G[now]) {
                val nc = c + nextC
                if (nc < dist[next]) {
                    dist[next] = nc
                    pq.add(Edge(next, nc))
                }
            }
        }
        return dist
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); E = last()
        }
        G = List(N) { mutableListOf<Edge>() }.apply {
            repeat(E) {
                readLine().split(" ").map { it.toInt() - 1 }.let { (a, b, c) ->
                    this[a].add(Edge(b, (c+1).toLong()))
                    this[b].add(Edge(a, (c+1).toLong()))
                }
            }
        }
        readLine().split(" ").map { it.toInt() - 1 }.run {
            v1 = first(); v2 = last()
        }
        // 1 ~ v1 + v2 ~ N
        // 1 ~ v2 + v1 ~ N
        val fromOne = dijk(0)
        if (fromOne[v1] == Int.MAX_VALUE.toLong() && fromOne[v2] == Int.MAX_VALUE.toLong()) {
            print(-1)
        } else {
            val fromV1 = dijk(v1)
            val fromV2 = dijk(v2)

            val answer = minOf(
                fromOne[v1] + fromV1[v2] + fromV2[N-1],
                fromOne[v2] + fromV2[v1] + fromV1[N-1]
            )
            if (answer < Int.MAX_VALUE.toLong()) {
                print(answer)
            } else {
                print(-1)
            }
        }
    }
}