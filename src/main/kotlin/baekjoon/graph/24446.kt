package baekjoon.graph

class `24446` {
    private data class Loc(
        val x: Int,
        val cnt: Int = 0,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, R) = readLine().trim().split(" ").map(String::toInt)
        val E = List(N) { mutableListOf<Int>() }.apply {
            repeat(M) {
                val (u, v) = readLine().trim().split(" ").map { it.toInt() - 1 }
                this[u].add(v)
                this[v].add(u)
            }
        }
        val visited = IntArray(N) { -1 }.apply {
            this[R - 1] = 0
        }
        val q = ArrayDeque<Loc>().apply {
            add(Loc(R - 1))
        }
        while (q.isNotEmpty()) {
            val (now, cnt) = q.removeFirst()

            for (next in E[now]) {
                if (visited[next] == -1) {
                    visited[next] = cnt + 1
                    q.add(Loc(next, cnt + 1))
                }
            }
        }
        print(visited.joinToString("\n"))
    }
}