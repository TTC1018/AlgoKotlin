package baekjoon.disjointset

import kotlin.math.sqrt

class `1774` {

    private lateinit var parent: IntArray

    data class Loc(
        val x: Int,
        val y: Int
    )

    data class Edge(
        val x: Int,
        val y: Int,
        val cost: Double
    )

    private fun findParent(node: Int): Int {
        if (node != parent[node])
            parent[node] = findParent(parent[node])

        return parent[node]
    }

    private fun unionParent(a: Int, b: Int) {
        val pa = findParent(a)
        val pb = findParent(b)

        if (pa < pb)
            parent[pb] = pa
        else
            parent[pa] = pb
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val S = Array(N) { readLine().split(" ").map { it.toInt() - 1 }.let { Loc(it.first(), it.last()) } }
        val P = Array(M) { readLine().split(" ").map { it.toInt() - 1 }.let { Loc(it.first(), it.last()) } }
        parent = IntArray(N) { it }

        var answer = 0.0
        for ((a, b) in P) {
            unionParent(a, b)
        }

        val edges = mutableListOf<Edge>().apply {
            for (i in 0 until N) {
                for (j in i+1 until N) {
                    val (ax, ay) = S[i]
                    val (bx, by) = S[j]

                    val abx = (ax - bx).toDouble()
                    val aby = (ay - by).toDouble()
                    val dist = sqrt(abx*abx + aby*aby)
                    add(Edge(i, j, dist))
                }
            }
        }
        edges.sortBy { it.cost }

        for ((x, y, cost) in edges) {
            if (findParent(x) != findParent(y)) {
                unionParent(x, y)
                answer += cost
            }
        }

        print("%.2f".format(answer))
    }

}

fun main() {

    `1774`().solution()

}