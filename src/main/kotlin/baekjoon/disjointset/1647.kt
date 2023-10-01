package baekjoon.disjointset

import java.util.PriorityQueue

class `1647` {
    private data class Route(
        val a: Int,
        val b: Int,
        val c: Int
    ) : Comparable<Route> {
        override fun compareTo(other: Route): Int {
            return c.compareTo(other.c)
        }
    }

    private lateinit var parent: IntArray

    private fun findParent(x: Int): Int {
        if (x != parent[x])
            parent[x] = findParent(parent[x])
        return parent[x]
    }

    private fun unionParent(a: Int, b: Int) {
        val (pa, pb) = parent[a] to parent[b]

        if (pa > pb)
            parent[pa] = pb
        else
            parent[pb] = pa
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        parent = IntArray(N + 1) { it }
        val q = PriorityQueue<Route>().apply {
            repeat(M) {
                val (a, b, c) = readLine().split(" ").map(String::toInt)
                add(Route(a, b, c))
            }
        }

        var answer = 0
        var longest = 0
        while (q.isNotEmpty()) {
            val (a, b, c) = q.remove()

            if (findParent(a) != findParent(b)) {
                unionParent(a, b)
                answer += c
                longest = c
            }
        }
        print(answer - longest) // 두개로 쪼개기
    }
}

fun main() {
    `1647`().solution()
}