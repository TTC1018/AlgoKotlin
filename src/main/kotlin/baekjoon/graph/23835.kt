package baekjoon.graph

class `23835` {
    private var N = 0
    private lateinit var B: List<MutableList<Int>>
    private lateinit var visited: BooleanArray
    private lateinit var answer: IntArray

    private fun dfs(now: Int, dest: Int, cnt: Int): Int {
        if (now == dest) {
            answer[now] += cnt
            return cnt
        }

        var returned = 0
        for (next in B[now]) {
            if (visited[next].not()) {
                visited[next] = true
                dfs(next, dest, cnt + 1)
                    .takeIf { it > 1 }
                    ?.run { returned += this - 1 }
                visited[next] = false
            }
        }
        answer[now] += returned
        return returned
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        visited = BooleanArray(N + 1) { false }
        answer = IntArray(N + 1)
        B = List(N + 1) { mutableListOf() }
        repeat(N - 1) {
            val (a, b) = readLine().split(" ").map(String::toInt)
            B[a].add(b); B[b].add(a)
        }
        val Q = readLine().toInt()
        repeat(Q) {
            val ops = readLine().split(" ").map(String::toInt)
            when (ops.first()) {
                1 -> {
                    visited[ops[1]] = true
                    dfs(ops[1], ops[2], 0)
                    visited[ops[1]] = false
                }
                2 -> {
                    println(answer[ops.last()])
                }
            }
        }
    }
}