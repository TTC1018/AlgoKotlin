package baekjoon.graph

class `1245` {
    private data class Step(
        val x: Int,
        val y: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(' ').map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        val d = listOf(
            Step(-1, -1), Step(-1, 0), Step(-1, 1),
            Step(0, -1), Step(0, 1),
            Step(1, -1), Step(1, 0), Step(1, 1)
        )
        val V = List(N) { BooleanArray(M) { false } }
        var answer = 0
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (V[i][j].not()) {
                    V[i][j] = true
                    val q = ArrayDeque<Step>().apply {
                        add(Step(i, j))
                    }

                    var top = true
                    while (q.isNotEmpty()) {
                        val (x, y) = q.removeFirst()

                        for ((dx, dy) in d) {
                            val (nx, ny) = x + dx to y + dy
                            if (nx in 0 until N && ny in 0 until M) {
                                if (B[nx][ny] == B[i][j] && V[nx][ny].not()) {
                                    V[nx][ny] = true
                                    q.add(Step(nx, ny))
                                } else if (B[nx][ny] > B[i][j]) {
                                    top = false
                                }
                            }
                        }
                    }

                    if (top && B[i][j] != 0)
                        answer++
                }
            }
        }
        print(answer)
    }
}