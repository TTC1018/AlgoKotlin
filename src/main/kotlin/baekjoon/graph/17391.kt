package baekjoon.graph

class `17391` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    private val d = listOf(
        Loc(1, 0), Loc(0, 1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }

        val visited = List(N) { IntArray(M) { Int.MAX_VALUE } }
        val q = ArrayDeque<Loc>().apply {
            visited[0][0] = 0
            add(Loc(0, 0))
        }

        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (x == N - 1 && y == M - 1) {
                print(cnt)
                return
            }

            for ((dx, dy) in d) {
                (1..B[x][y]).forEach {
                    val nx = (x + dx * it).coerceAtMost(N - 1)
                    val ny = (y + dy * it).coerceAtMost(M - 1)

                    if (cnt + 1 < visited[nx][ny]) {
                        visited[nx][ny] = cnt + 1
                        q.add(Loc(nx, ny, cnt + 1))
                    }
                }
            }
        }
    }
}