package baekjoon.graph

class `16469` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val idx: Int = 0,
        val cnt: Int = 0,
    )

    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (R, C) = readLine().split(" ").map(String::toInt)
        val B = List(R) { readLine() }
        val V = List(R) { List(C) { IntArray(3) { INF } } }
        val q = ArrayDeque<Loc>().apply {
            repeat(3) {
                readLine().split(" ").map { it.toInt() - 1 }.run {
                    V[first()][last()][it] = 0
                    add(Loc(first(), last(), it))
                }
            }
        }
        while (q.isNotEmpty()) {
            val (x, y, idx, cnt) = q.removeFirst()
            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until R && ny in 0 until C) {
                    if (B[nx][ny] == '0' && cnt + 1 < V[nx][ny][idx]) {
                        V[nx][ny][idx] = cnt + 1
                        q.add(Loc(nx, ny, idx, cnt + 1))
                    }
                }
            }
        }

        val maxV = List(R) { r -> IntArray(C) { c -> V[r][c].maxOf { it } } }
        var answerVal = INF
        var answer = 0

        for (i in 0 until R) {
            for (j in 0 until C) {
                if (answerVal == maxV[i][j]) {
                    answer++
                } else if (answerVal > maxV[i][j]) {
                    answer = 1
                    answerVal = maxV[i][j]
                }
            }
        }

        if (answerVal == INF) {
            print(-1)
        } else {
            print("$answerVal\n$answer")
        }
    }

    companion object {
        private const val INF = 1e9.toInt()
    }
}