package baekjoon.graph

class `16509` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    private val d = listOf(
        listOf(Loc(-1, 0), Loc(-1, -1), Loc(-1, -1)),
        listOf(Loc(-1, 0), Loc(-1, 1), Loc(-1, 1)),
        listOf(Loc(0, -1), Loc(-1, -1), Loc(-1, -1)),
        listOf(Loc(0, -1), Loc(1, -1), Loc(1, -1)),
        listOf(Loc(0, 1), Loc(-1, 1), Loc(-1, 1)),
        listOf(Loc(0, 1), Loc(1, 1), Loc(1, 1)),
        listOf(Loc(1, 0), Loc(1, -1), Loc(1, -1)),
        listOf(Loc(1, 0), Loc(1, 1), Loc(1, 1))
    )

    private val inRange: (Int, Int) -> Boolean = { x, y -> x in 0 until 10 && y in 0 until 9 }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (R1, C1) = readLine().split(" ").map(String::toInt)
        val (R2, C2) = readLine().split(" ").map(String::toInt)
        val V = List(10) { BooleanArray(9) { false } }

        val q = ArrayDeque<Loc>().apply {
            V[R1][C1] = true
            add(Loc(R1, C1, 0))
        }

        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (x == R2 && y == C2) {
                print(cnt)
                return
            }

            loop@ for (steps in d) {
                var (nx, ny) = x to y
                for (i in 0..1) {
                    nx += steps[i].x
                    ny += steps[i].y

                    if (inRange(nx, ny)) {
                        if (nx == R2 && ny == C2) {
                            continue@loop
                        }
                    } else {
                        continue@loop
                    }
                }

                nx += steps.last().x
                ny += steps.last().y
                if (inRange(nx, ny) && V[nx][ny].not()) {
                    V[nx][ny] = true
                    q.add(Loc(nx, ny, cnt + 1))
                }
            }
        }
        print(-1)
    }
}