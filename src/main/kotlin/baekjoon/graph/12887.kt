package baekjoon.graph

class `12887` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    private val right = Loc(0, 1)
    private val updown = listOf(Loc(1, 0), Loc(-1, 0))

    fun solution() = with(System.`in`.bufferedReader()) {
        val M = readLine().toInt()
        val B = List(2) { readLine() }
        val visited = List(2) { BooleanArray(M) { false } }
        val q = ArrayDeque<Loc>().apply {
            if (B[0][0] == '.'){
                add(Loc(0, 0, 1))
                visited[0][0] = true
            }
            if (B[1][0] == '.') {
                add(Loc(1, 0, 1))
                visited[1][0] = true
            }
        }

        var answer = 2*M
        for (i in 0 until 2) {
            for (j in 0 until M) {
                if (B[i][j] == '#')
                    answer--
            }
        }

        var minPath = Int.MAX_VALUE
        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (y == M-1) {
                minPath = minOf(minPath, cnt)
                continue
            }

            val fx = x+right.x
            val fy = y+right.y
            if (B[fx][fy] == '.' && visited[fx][fy].not()) {
                visited[fx][fy] = true
                q.add(Loc(fx, fy, cnt + 1))
            } else {
                val nx = x+updown[x].x
                val ny = y+updown[x].y
                if (B[nx][ny] == '.' && visited[nx][ny].not()) {
                    visited[nx][ny] = true
                    q.add(Loc(nx, ny, cnt + 1))
                }
            }
        }
        print(answer - minPath)
    }
}