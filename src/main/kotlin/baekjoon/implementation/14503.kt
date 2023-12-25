package baekjoon.implementation

class `14503` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val (r, c, d) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt).toIntArray() }
        val V = List(N) { BooleanArray(M) { false } }
        val D = listOf(
            Loc(-1, 0), Loc(0, 1), Loc(1, 0), Loc(0, -1)
        )

        var (x, y) = r to c
        var nd = d
        var answer = 0
        var dCnt = 0
        while (true) {
            if (B[x][y] == 0 && V[x][y].not()) {
                V[x][y] = true
                answer++
            }

            nd = (nd - 1).mod(4)
            val (nx, ny) = x + D[nd].x to y + D[nd].y
            if (B[nx][ny] == 0 && V[nx][ny].not()) {
                x = nx; y = ny
                dCnt = 0
            } else {
                dCnt++
                if (dCnt == 4) {
                    dCnt = 0
                    x -= D[nd].x
                    y -= D[nd].y
                    if (B[x][y] == 1) {
                        break
                    }
                }
            }
        }
        print(answer)
    }
}