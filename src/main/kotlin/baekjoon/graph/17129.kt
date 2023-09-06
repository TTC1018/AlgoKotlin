package baekjoon.graph

class `17129` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0
    )

    private val d = listOf(
        Loc(1, 0), Loc(0, 1), Loc(-1, 0), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map(String::toInt)
        val b = Array(n) { readLine().toCharArray().map(Char::digitToInt).toIntArray() }
        val visited = Array(n) { BooleanArray(m) { false } }
        val q = ArrayDeque<Loc>().apply {
            b.forEachIndexed { i, row ->
                row.forEachIndexed { j, col ->
                    if (col == 2) {
                        add(Loc(i, j))
                        visited[i][j] = true
                    }
                }
            }
        }

        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (b[x][y] > 2) {
                print("TAK\n$cnt")
                return
            }

            d.forEach { (dx, dy) ->
                val (nx, ny) = x + dx to y + dy

                if (nx in 0 until n && ny in 0 until m) {
                    if (b[nx][ny] != 1 && visited[nx][ny].not()) {
                        visited[nx][ny] = true
                        q.add(Loc(nx, ny, cnt + 1))
                    }
                }
            }
        }

        print("NIE")
    }
}

fun main() {
    `17129`().solution()
}