package baekjoon.graph

class `25513` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val num: Int = 0,
        val cnt: Int = 0,
    )

    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))

    fun solution() = with(System.`in`.bufferedReader()) {
        val B = List(5) { readLine().split(" ").map(String::toInt) }
        val (sx, sy) = readLine().split(" ").map(String::toInt)
        val V = List(5) { List(5) { IntArray(6 + 1) { Int.MAX_VALUE } } }

        val q = ArrayDeque<Loc>().apply {
            add(Loc(sx, sy))
            V[sx][sy][0] = 0
        }

        while (q.isNotEmpty()) {
            val (x, y, num, cnt) = q.removeFirst()
            if (num == 6) {
                print(cnt)
                return
            }

            d.forEach { (dx, dy) ->
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until 5 && ny in 0 until 5) {
                    if (B[nx][ny] != -1) {
                        if (cnt + 1 < V[nx][ny][num]) {
                            V[nx][ny][num] = cnt + 1
                            if (B[nx][ny] == num + 1) {
                                if (cnt + 1 < V[nx][ny][num + 1]) {
                                    V[nx][ny][num + 1] = cnt + 1
                                    q.add(Loc(nx, ny, num + 1, cnt + 1))
                                }
                            } else {
                                q.add(Loc(nx, ny, num, cnt + 1))
                            }
                        }
                    }
                }
            }
        }
        print(-1)
    }
}