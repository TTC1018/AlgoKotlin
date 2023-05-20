package baekjoon.graph

class `2206` {

    data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 1,
        val wFlag: Int = 0
    )

    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val B = Array(N) { readLine().toCharArray().map { it.digitToInt() }.toIntArray() }
        val visited = Array(N) { Array(M) { IntArray(2) { 1e9.toInt() } } }
            .also { it[0][0][0] = 0; it[0][0][1] = 0 }
        val inRange: (Int, Int) -> Boolean = { x, y -> x in 0 until N && y in 0 until M }

        val q = ArrayDeque<Loc>().apply { add(Loc(0, 0)) }
        while (q.isNotEmpty()) {
            val (x, y, cnt, used) = q.removeFirst()
            if (x == N - 1 && y == M - 1) {
                print(cnt)
                return
            }

            d.forEach { (dx, dy) ->
                val nx = x + dx
                val ny = y + dy

                if (inRange(nx, ny)) {
                    when (B[nx][ny]) {
                        0 -> {
                            if (cnt + 1 < visited[nx][ny][used]) {
                                visited[nx][ny][used] = cnt + 1
                                q.add(Loc(nx, ny, cnt + 1, used))
                            }
                        }
                        1 -> {
                            if (used == 0 && cnt + 1 < visited[nx][ny][1]) {
                                visited[nx][ny][1] = cnt + 1
                                q.add(Loc(nx, ny, cnt + 1, 1))
                            }
                        }
                    }
                }
            }
        }
        print(-1)
    }

}

fun main() {

    `2206`().solution()

}