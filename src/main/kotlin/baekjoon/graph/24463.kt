package baekjoon.graph

class `24463` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    private var N = 0
    private var M = 0
    private var s: Loc? = null
    private var e: Loc? = null
    private lateinit var q: ArrayDeque<Loc>
    private lateinit var B: List<CharArray>
    private lateinit var V: List<IntArray>

    private fun bfs() {
        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (e?.x == x && e?.y == y) {
                break
            }

            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until N && ny in 0 until M) {
                    if (B[nx][ny] == '.') {
                        V[nx][ny] = cnt + 1
                        B[nx][ny] = '@'
                        q.add(Loc(nx, ny, cnt + 1))
                    }
                }
            }
        }
    }

    private fun reverseBfs() {
        q.clear()
        e?.run { q.add(Loc(x, y, V[x][y])); B[x][y] = '.' }
        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (s?.x == x && s?.y == y) {
                break
            }

            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until N && ny in 0 until M) {
                    if (B[nx][ny] == '@' && V[nx][ny] == cnt - 1) {
                        B[nx][ny] = '.'
                        q.add(Loc(nx, ny, cnt - 1))
                    }
                }
            }
        }
    }

    private fun fillBlockedSpace() {
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (B[i][j] != '+' && V[i][j] == Int.MAX_VALUE) {
                    B[i][j] = '@'
                }
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        B = List(N) { readLine().toCharArray() }.apply {
            for (i in 0 until N) {
                for (j in 0 until M) {
                    if (this[i][j] == '.' && (i == 0 || i == N - 1 || j == 0 || j == M - 1)) {
                        if (s == null) {
                            s = Loc(i, j)
                        } else {
                            e = Loc(i, j)
                        }
                    }
                }
            }
        }
        V = List(N) { IntArray(M) { Int.MAX_VALUE } }.apply { s?.run { this@apply[x][y] = 0 } }
        q = ArrayDeque<Loc>().apply { s?.run { add(Loc(x, y)); B[x][y] = '@' } }
        bfs(); reverseBfs(); fillBlockedSpace()
        print(B.joinToString("\n") { it.joinToString("") })
    }
}