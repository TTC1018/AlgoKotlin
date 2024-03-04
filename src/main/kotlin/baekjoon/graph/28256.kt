package baekjoon.graph

class `28256` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val B = List(3) { readLine().toCharArray() }
            val nums = readLine().split(" ").map(String::toInt).drop(1).sorted()

            val V = List(3) { BooleanArray(3) { false } }
            val cands = mutableListOf<Int>()
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    if (B[i][j] == 'O' && V[i][j].not()) {
                        V[i][j] = true
                        var cnt = 1
                        val q = ArrayDeque<Loc>().apply {
                            add(Loc(i, j))
                        }

                        while (q.isNotEmpty()) {
                            val (x, y) = q.removeFirst()

                            for ((dx, dy) in d) {
                                val (nx, ny) = x + dx to y + dy
                                if (nx in 0 until 3 && ny in 0 until 3) {
                                    if (B[nx][ny] == 'O' && V[nx][ny].not()) {
                                        V[nx][ny] = true
                                        cnt++
                                        q.add(Loc(nx, ny))
                                    }
                                }
                            }
                        }
                        cands.add(cnt)
                    }
                }
            }

            cands.sort()
            if (nums == cands) {
                sb.appendLine(1)
            } else {
                sb.appendLine(0)
            }
        }
        print(sb.dropLast(1))
    }
}