package baekjoon.graph

class `22352` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val O = List(N) { readLine().split(" ").map(String::toInt).toIntArray() }
        val A = List(N) { readLine().split(" ").map(String::toInt).toIntArray() }
        val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))

        var used = false
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (O[i][j] != A[i][j]) {
                    val origin = O[i][j]
                    O[i][j] = A[i][j]
                    if (used) {
                        print("NO")
                        return
                    } else {
                        used = true
                        val q = ArrayDeque<Loc>().apply {
                            add(Loc(i, j))
                        }
                        while (q.isNotEmpty()) {
                            val (x, y) = q.removeFirst()

                            for ((dx, dy) in d) {
                                val (nx, ny) = x + dx to y + dy
                                if (nx in 0 until N && ny in 0 until M) {
                                    if (O[nx][ny] == origin) {
                                        O[nx][ny] = A[i][j]
                                        q.add(Loc(nx, ny))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (O[i][j] != A[i][j]) {
                    print("NO")
                    return
                }
            }
        }
        print("YES")
    }
}