package baekjoon.implementation

class `2638` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    private var N = 0
    private var M = 0
    private lateinit var B: List<IntArray>
    private lateinit var O: List<BooleanArray>
    private var target = mutableListOf<Loc>()

    private fun searchTarget(locs: MutableList<Loc>) {
        for (i in 1 until N - 1) {
            for (j in 1 until M - 1) {
                if (B[i][j] == 1 && d.count { (dx, dy) -> B[i + dx][j + dy] == 0 && O[i + dx][j + dy].not() } >= 2) {
                    locs.add(Loc(i, j))
                }
            }
        }
    }

    private fun spreadArea(sx: Int, sy: Int) {
        O[sx][sy] = false
        val q = ArrayDeque<Loc>().apply { add(Loc(sx, sy)) }
        while (q.isNotEmpty()) {
            val (x, y) = q.removeFirst()
            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until N && ny in 0 until M) {
                    if (B[nx][ny] == 0 && O[nx][ny]) {
                        O[nx][ny] = false
                        q.add(Loc(nx, ny))
                    }
                }
            }
        }
    }

    private fun eraseTarget() {
        for ((x, y) in target) {
            B[x][y] = 0
            spreadArea(x, y)
        }
    }

    fun main() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        B = List(N) { readLine().split(" ").map(String::toInt).toIntArray() }
        O = List(N) { BooleanArray(M) { true } }
        spreadArea(0, 0)
        searchTarget(target)

        var cnt = 0
        while (target.isNotEmpty()) {
            cnt++
            val next = mutableListOf<Loc>()
            eraseTarget()
            searchTarget(next)
            target = next
        }
        print(cnt)
    }
}