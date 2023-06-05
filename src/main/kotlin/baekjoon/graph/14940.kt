package baekjoon.graph

class `14940` {

    data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0
    )

    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))

    fun solution() = with(System.`in`.bufferedReader()) {

        val (n, m) = readLine().split(" ").map { it.toInt() }
        val q = ArrayDeque<Loc>()
        val visited = Array(n) { BooleanArray(m) { false } }
        val answer = Array(n) { IntArray(m) }
        val G = Array(n) { i ->
            readLine().split(" ").map { it.toInt() }.toIntArray()
                .let {
                    for (j in it.indices) {
                        when (it[j]) {
                            1 -> answer[i][j] = -1
                            2 -> {
                                q.add(Loc(i, j))
                                visited[i][j] = true
                                answer[i][j] = 0
                            }
                        }
                    }
                    it
                }
        }


        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()

            for ((dx, dy) in d) {
                val nx = x + dx
                val ny = y + dy

                if (nx in 0 until n && ny in 0 until m) {
                    if (G[nx][ny] == 1 && visited[nx][ny].not()) {
                        visited[nx][ny] = true
                        answer[nx][ny] = cnt + 1
                        q.add(Loc(nx, ny, cnt + 1))
                    }
                }
            }
        }

        print(answer.joinToString("\n") { it.joinToString( " ") })
    }

}

fun main() {

    `14940`().solution()

}