package baekjoon.graph

class `12784` {
    data class Route(
        val next: Int,
        val d: Int
    )

    private var N = 0
    private var M = 0
    private lateinit var graph: Array<MutableList<Route>>

    private fun dfs(prev: Int, now: Int, dist: Int): Int {
        var childs = 0
        for ((next, d) in graph[now]) {
            if (prev == next)
                continue

            childs += dfs(now, next, d)
        }

        if (childs == 0)
            return dist
        return minOf(childs, dist)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        repeat(readLine().toInt()) {
            readLine().split(" ").map(String::toInt).run { N = this[0]; M = this[1] }
            graph = Array(N) { mutableListOf() }
            repeat(M) {
                var (a, b, D) = readLine().split(" ").map { it.toInt() - 1 }
                D++

                graph[a].add(Route(b, D))
                graph[b].add(Route(a, D))
            }

            val answer = dfs(-1, 0, Int.MAX_VALUE)
            println(if (answer == Int.MAX_VALUE) 0 else answer)
        }
    }
}

fun main() {
    `12784`().solution()
}