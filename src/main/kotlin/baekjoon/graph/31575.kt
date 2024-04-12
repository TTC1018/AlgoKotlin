package baekjoon.graph

class `31575` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val C = List(M) { readLine().split(" ").map(String::toInt) }
        val V = List(M) { BooleanArray(N) { false } }
        val q = ArrayDeque<Loc>().apply {
            V[0][0] = true
            add(Loc(0, 0))
        }
        val d = listOf(Loc(1, 0), Loc(0, 1))
        while (q.isNotEmpty()) {
            val (x, y) = q.removeFirst()
            if (x == M - 1 && y == N - 1) {
                print("Yes")
                return
            }
            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until M && ny in 0 until N) {
                    if (C[nx][ny] == 1 && V[nx][ny].not()) {
                        V[nx][ny] = true
                        q.add(Loc(nx, ny))
                    }
                }
            }
        }
        print("No")
    }
}