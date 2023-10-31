package baekjoon.graph

class `13903` {
    private data class Step(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (R, C) = readLine().split(" ").map(String::toInt)
        val B = List(R) { readLine().split(" ").map(String::toInt) }
        val d = List(readLine().toInt()) { readLine().split(" ").map(String::toInt).run { Step(first(), last()) } }

        val visited = List(R) { BooleanArray(C) { false } }
        val q = ArrayDeque<Step>().apply {
            for (i in B.first().indices) {
                if (B.first()[i] == 1) {
                    add(Step(0, i))
                    visited[0][i] = true
                }
            }
        }

        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (x == R - 1) {
                print(cnt)
                return
            }

            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until R && ny in 0 until C) {
                    if (visited[nx][ny].not() && B[nx][ny] == 1) {
                        visited[nx][ny] = true
                        q.add(Step(nx, ny, cnt + 1))
                    }
                }
            }
        }
        print(-1)
    }
}