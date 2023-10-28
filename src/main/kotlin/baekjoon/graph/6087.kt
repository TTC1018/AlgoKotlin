package baekjoon.graph

class `6087` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val prev: Int = -1,
        val cnt: Int = 0,
    ) {
        override fun equals(other: Any?): Boolean {
            val o = other as Loc?
            return x == o?.x && y == o.y
        }
    }

    private var W = 0
    private var H = 0
    private lateinit var B: List<String>
    private lateinit var visited: List<IntArray>
    private lateinit var s: Loc
    private lateinit var e: Loc
    private val d = listOf(
        Loc(1, 0), Loc(0, 1), Loc(0, -1), Loc(-1, 0)
    )
    private val oppo = buildMap {
        put(0, 3)
        put(3, 0)
        put(1, 2)
        put(2, 1)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            W = first(); H = last()
        }
        var sFlag = false
        B = List(H) { i ->
            readLine().also {
                for (j in it.indices) {
                    if (it[j] == 'C') {
                        if (sFlag.not()) {
                            sFlag = true
                            s = Loc(i, j)
                        } else {
                            e = Loc(i, j)
                        }
                    }
                }
            }
        }
        visited = List(H) { IntArray(W) { Int.MAX_VALUE } }
        visited[s.x][s.y] = 0
        val q = ArrayDeque<Loc>().apply {
            for (i in d.indices)
                add(Loc(s.x, s.y, i))
        }
        var answer = Int.MAX_VALUE
        while (q.isNotEmpty()) {
            val (x, y, prev, cnt) = q.removeFirst()
            if (x == e.x && y == e.y) {
                answer = minOf(answer, cnt)
                continue
            }

            for (i in d.indices) {
                if (i == oppo[prev])
                    continue

                var (nx, ny) = x + d[i].x to y + d[i].y
                while (nx in 0 until H && ny in 0 until W && B[nx][ny] != '*') {
                    if (prev == i && cnt < visited[nx][ny]) {
                        visited[nx][ny] = cnt
                        q.add(Loc(nx, ny, i, cnt))
                    } else if (prev != i && cnt + 1 < visited[nx][ny]) {
                        visited[nx][ny] = cnt + 1
                        q.add(Loc(nx, ny, i, cnt + 1))
                    }
                    nx += d[i].x
                    ny += d[i].y
                }
            }
        }
        print(answer)
    }
}