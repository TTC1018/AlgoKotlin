package baekjoon.graph

class `19952` {
    private var H = 0
    private var W = 0
    private var O = 0
    private var F = 0
    private var sx = 0
    private var sy = 0
    private var ex = 0
    private var ey = 0
    private lateinit var B: List<IntArray>
    private lateinit var V: List<BooleanArray>

    private data class Loc(
        val x: Int,
        val y: Int,
        val left: Int = 0,
    )

    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        var T = readLine().toInt()
        loop@ while (T-- > 0) {
            readLine().split(" ").map(String::toInt).let {
                H = it[0]; W = it[1]; O = it[2]; F = it[3]
                sx = it[4] - 1; sy = it[5] - 1; ex = it[6] - 1; ey = it[7] - 1
            }
            B = List(H) { IntArray(W) }.apply {
                if (O > 0) {
                    repeat(O) {
                        val (x, y, l) = readLine().split(" ").map(String::toInt)
                        this[x - 1][y - 1] = l
                    }
                }
            }
            V = List(H) { BooleanArray(W) { false } }

            val q = ArrayDeque<Loc>().apply {
                add(Loc(sx, sy, F))
                V[sx][sy] = true
            }

            while (q.isNotEmpty()) {
                val (x, y, left) = q.removeFirst()
                if (x == ex && y == ey) {
                    sb.appendLine("잘했어!!")
                    continue@loop
                }

                d.forEach { (dx, dy) ->
                    val (nx, ny) = x + dx to y + dy
                    if (nx in 0 until H && ny in 0 until W) {
                        val need = (B[nx][ny] - B[x][y]).coerceAtLeast(0)
                        if (left > 0 && left >= need && V[nx][ny].not()) {
                            V[nx][ny] = true
                            q.add(Loc(nx, ny, left - 1))
                        }
                    }
                }
            }
            sb.appendLine("인성 문제있어??")
        }
        print(sb.dropLast(1))
    }
}