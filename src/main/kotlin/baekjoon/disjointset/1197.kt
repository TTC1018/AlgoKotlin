package baekjoon.disjointset

import java.util.PriorityQueue

class `1197` {

    data class Edge(
        val start: Int,
        val dest: Int,
        val cost: Int
    ) : Comparable<Edge> {
        override fun compareTo(other: Edge) =
            this.cost.compareTo(other.cost)
    }

    private lateinit var parents: IntArray

    private fun findParent(node: Int): Int {
        if (node != parents[node])
            parents[node] = findParent(parents[node])
        return parents[node]
    }

    private fun unionParent(a: Int, b: Int) {

        val pA = findParent(a)
        val pB = findParent(b)

        if (pA <= pB)
            parents[pB] = pA
        else
            parents[pA] = pB

    }


    fun solution() = with(System.`in`.bufferedReader()) {

        val (V, E) = readLine().split(" ").map { it.toInt() }
        parents = IntArray(V) { it }
        val edges = PriorityQueue<Edge>()

        repeat(E) {

            var (A, B, C) = readLine().split(" ").map { it.toInt() }
            A -= 1; B -= 1
            edges.add(Edge(A, B, C))

        }

        var count = 0
        var answer = 0
        while (edges.isNotEmpty() && count < V - 1) {
            val (A, B, C) = edges.remove()
            if (findParent(A) != findParent(B)) {
                unionParent(A, B)
                count++
                answer += C
            }
        }

        print(answer)
    }

}

fun main() {

    `1197`().solution()

}