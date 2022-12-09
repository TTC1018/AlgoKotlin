package baekjoon.graph

class `1240` {

    data class NextNode(
        val dest: Int,
        val cost: Int
    )

    private lateinit var graph: List<MutableList<NextNode>>
    private var target = -1
    private var answer = 0

    private fun dfs(now: Int, prev: Int, total: Int) {
        if (now == target) {
            answer = total
            return
        }

        for ((next, cost) in graph[now]) {
            if (next != prev) {
                dfs(next, now, total + cost)
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        graph = List(N) { mutableListOf() }
        repeat(N - 1) {
            val (A, B, dist) = readLine().split(" ").map { it.toInt() }
            graph[A - 1].add(NextNode(B - 1, dist))
            graph[B - 1].add(NextNode(A - 1, dist))
        }

        repeat(M) {
            val (A, B) = readLine().split(" ").map { it.toInt() }
            target = B - 1
            dfs(A - 1, -1, 0)
            println(answer)
        }

    }

}

fun main() {

    `1240`().solution()

}