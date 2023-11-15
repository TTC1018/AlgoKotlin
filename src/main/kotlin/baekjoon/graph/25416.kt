package baekjoon.graph

class `25416` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val B = List(5) { readLine().split(" ").map(String::toInt) }
        val (r, c) = readLine().split(" ").map(String::toInt)
        var visited = (1 shl r*5+c)
        val q = ArrayDeque<Loc>().apply {
            add(Loc(r, c, 0))
        }

        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (B[x][y] == 1) {
                print(cnt)
                return
            }

            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until 5 && ny in 0 until 5) {
                    if (B[nx][ny] != -1 && visited and (1 shl nx*5+ny) == 0) {
                        visited  = visited or (1 shl nx*5+ny)
                        q.add(Loc(nx, ny, cnt + 1))
                    }
                }
            }
        }
        print(-1)
    }
}