package baekjoon.graph

class `6146` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    private val d = listOf(
        Loc(1, 0), Loc(0, 1), Loc(-1, 0), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (X, Y, N) = readLine().split(" ").map(String::toInt)
        val swamp = buildSet<Loc> {
            repeat(N) {
                add(readLine().split(" ").map(String::toInt).run { Loc(first(), last()) })
            }
        }
        val s = Loc(0, 0)
        val visited = mutableSetOf<Loc>().apply { add(s) }
        val q = ArrayDeque<Loc>().apply { add(s) }

        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (x == X && y == Y) {
                print(cnt)
                return
            }

            for ((dx, dy, _) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in -500..500 && ny in -500..500) {
                    val next = Loc(nx, ny)
                    if (next !in visited && next !in swamp) {
                        visited.add(next)
                        q.add(Loc(nx, ny, cnt + 1))
                    }
                }
            }
        }
    }
}