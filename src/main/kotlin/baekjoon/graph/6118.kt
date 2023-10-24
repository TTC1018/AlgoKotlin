package baekjoon.graph

class `6118` {
    private lateinit var G: List<MutableList<Int>>
    private lateinit var visited: IntArray

    private data class Loc(
        val x: Int,
        val cnt: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        G = List(N) { mutableListOf() }
        visited = IntArray(N) { -1 }
        repeat(M) {
            val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
            G[a].add(b); G[b].add(a)
        }

        visited[0] = 0
        val q = ArrayDeque<Loc>().apply { add(Loc(0, 0)) }
        while (q.isNotEmpty()) {
            val (now, cnt) = q.removeFirst()

            for (next in G[now]) {
                if (visited[next] == -1) {
                    visited[next] = cnt + 1
                    q.add(Loc(next, cnt + 1))
                }
            }
        }

        val maxVal = visited.maxOf { it }
        print("${visited.indexOfFirst { it == maxVal } + 1} $maxVal ${visited.count { it == maxVal }}")
    }
}