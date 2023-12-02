package baekjoon.graph

class `17836` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
        val g: Boolean = false,
    )

    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, T) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        val visited = List(N) { List(M) { BooleanArray(2) { false } } }.apply {
            this[0][0][0] = true
        }
        val q = ArrayDeque<Loc>().apply {
            add(Loc(0, 0))
        }
        while (q.isNotEmpty()) {
            val (x, y, cnt, g) = q.removeFirst()
            if (x == N - 1 && y == M - 1) {
                print(cnt)
                return
            }

            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until N && ny in 0 until M && cnt + 1 <= T) {
                    if (B[nx][ny] == 1) {
                        if (g && visited[nx][ny][1].not()) {
                            visited[nx][ny][1] = true
                            q.add(Loc(nx, ny, cnt + 1, g))
                        }
                    } else {
                        if (visited[nx][ny][if (g) 1 else 0].not()) {
                            visited[nx][ny][if (g) 1 else 0] = true
                            if (B[nx][ny] == 2) {
                                q.add(Loc(nx, ny, cnt + 1, true))
                            } else {
                                q.add(Loc(nx, ny, cnt + 1, g))
                            }
                        }
                    }
                }
            }
        }
        print("Fail")
    }
}