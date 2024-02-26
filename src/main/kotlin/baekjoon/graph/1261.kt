package baekjoon.graph

class `1261` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    private val d = listOf(Loc(1, 0), Loc(0, 1), Loc(-1, 0), Loc(0, -1))

    fun solution() = with(System.`in`.bufferedReader()) {
        val (M, N) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().toCharArray().map(Char::digitToInt) }
        val V = List(N) { IntArray(M) { Int.MAX_VALUE } }
        val q = ArrayDeque<Loc>().apply {
            add(Loc(0, 0))
            V[0][0] = 0
        }

        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (x == N - 1 && y == M - 1) {
                continue
            }

            d.forEach { (dx, dy) ->
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until N && ny in 0 until M) {
                    if (B[nx][ny] == 0 && cnt < V[nx][ny]) {
                        V[nx][ny] = cnt
                        q.add(Loc(nx, ny, cnt))
                    } else if (B[nx][ny] == 1 && cnt + 1 < V[nx][ny]) {
                        V[nx][ny] = cnt + 1
                        q.add(Loc(nx, ny, cnt + 1))
                    }
                }
            }
        }
        print(V.last().last())
    }
}