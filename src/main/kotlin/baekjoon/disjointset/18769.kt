package baekjoon.disjointset

import java.util.*

class `18769` {
    private lateinit var P: IntArray

    private data class Edge(
        val x: Int,
        val y: Int,
        val c: Int,
    ) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            return c.compareTo(other.c)
        }
    }

    private fun findParent(x: Int): Int {
        if (x != P[x])
            P[x] = findParent(P[x])
        return P[x]
    }

    private fun unionParent(a: Int, b: Int) {
        val (pa, pb) = findParent(a) to findParent(b)
        if (pa < pb) {
            P[pb] = pa
        } else if (pa > pb) {
            P[pa] = pb
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        for (t in 0 until readLine().toInt()) {
            val (R, C) = readLine().split(" ").map(String::toInt)
            P = IntArray(R * C) { it }
            val pq = PriorityQueue<Edge>().apply {
                for (i in 0 until R) {
                    val costs = readLine().split(" ").map(String::toInt)
                    for (j in 0 until C - 1) {
                        add(Edge(i * C + j, i * C + (j + 1), costs[j]))
                    }
                }
                for (i in 0 until R - 1) {
                    val costs = readLine().split(" ").map(String::toInt)
                    for (j in 0 until C) {
                        add(Edge(i * C + j, (i + 1) * C + j, costs[j]))
                    }
                }
            }

            var cnt = 1
            var answer = 0
            while (pq.isNotEmpty()) {
                val (x, y, c) = pq.remove()

                if (findParent(x) != findParent(y)) {
                    unionParent(x, y)
                    answer += c
                    cnt++

                    if (cnt == R * C) {
                        break
                    }
                }
            }
            sb.append(answer).append("\n")
        }
        print(sb)
    }
}