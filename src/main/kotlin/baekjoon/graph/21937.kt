package baekjoon.graph

class `21937` {
    private var N = 0
    private var M = 0
    private var X = 0
    private lateinit var P: List<MutableList<Int>>
    private lateinit var visited: BooleanArray
    private var answer = 0

    private fun dfs(now: Int) {
        for (prev in P[now]) {
            if (visited[prev].not()) {
                visited[prev] = true
                answer++
                dfs(prev)
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        visited = BooleanArray(N) { false }
        P = List<MutableList<Int>>(N) { mutableListOf() }.apply {
            repeat(M) {
                val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
                this[b].add(a)
            }
        }
        X = readLine().toInt() - 1
        visited[X] = true
        dfs(X)
        print(answer)
    }
}