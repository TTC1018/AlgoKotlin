package baekjoon.graph

class `27211` {
    private data class Step(
        val x: Int,
        val y: Int,
    )

    private val d = listOf(
        Step(1, 0), Step(-1, 0), Step(0, 1), Step(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }

        val visited = List(N) { BooleanArray(M) { false } }
        var answer = 0
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (B[i][j] == 0 && visited[i][j].not()) {
                    answer++
                    visited[i][j] = true
                    val q = ArrayDeque<Step>().apply {
                        add(Step(i, j))
                    }

                    while (q.isNotEmpty()) {
                        val (x, y) = q.removeFirst()
                        for ((dx, dy) in d) {
                            val (nx, ny) = (x + dx).mod(N) to (y + dy).mod(M)
                            if (B[nx][ny] != 1 && visited[nx][ny].not()) {
                                visited[nx][ny] = true
                                q.add(Step(nx, ny))
                            }
                        }
                    }
                }
            }
        }
        print(answer)
    }
}