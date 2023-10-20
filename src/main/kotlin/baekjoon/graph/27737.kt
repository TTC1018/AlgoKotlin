package baekjoon.graph

class `27737` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, K) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt).toIntArray() }
        var answer = 0
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (B[i][j] == 0) {
                    var q = ArrayDeque<Loc>()
                    q.addLast(Loc(i, j))
                    B[i][j] = 1
                    var cnt = 1
                    while (q.isNotEmpty()) {
                        val next = ArrayDeque<Loc>()
                        q.forEach { (x, y) ->
                            for ((dx, dy) in d) {
                                val (nx, ny) = x + dx to y + dy
                                if (nx in 0 until N && ny in 0 until N) {
                                    if (B[nx][ny] == 0) {
                                        cnt++
                                        B[nx][ny] = 1
                                        next.addLast(Loc(nx, ny))
                                    }
                                }
                            }
                        }
                        q = next
                    }

                    answer += (kotlin.math.ceil(cnt.toDouble().div(K)).toInt())
                }
            }
        }

        if (answer == 0 || answer > M) {
            print("IMPOSSIBLE")
        } else {
            println("POSSIBLE")
            print(M - answer)
        }
    }
}