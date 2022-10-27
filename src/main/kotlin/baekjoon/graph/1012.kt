package baekjoon.graph

class `1012` {

    private val dx = listOf(-1, 1, 0, 0)
    private val dy = listOf(0, 0, -1, 1)

    data class Pos(
        val x: Int,
        val y: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val T = readLine().toInt()

        repeat(T) {

            var answer = 0
            val (M, N, K) = readLine().split(" ").map { it.toInt() }
            val field = Array(M) { IntArray(N) { 0 } }
            val visited = Array(M) { BooleanArray(N) { false } }
            repeat(K) {
                val (x, y) = readLine().split(" ").map { it.toInt() }
                field[x][y] = 1
            }

            for (i in 0 until M) {
                for (j in 0 until N) {
                    if (field[i][j] == 1 && visited[i][j].not()) {
                        bfs(i, j, M, N, field, visited)
                        answer++
                    }

                }
            }
            println(answer)

        }

    }

    private fun bfs(x: Int, y: Int, M: Int, N: Int, field: Array<IntArray>, visited: Array<BooleanArray>) {
        val q = ArrayDeque<Pos>().apply { add(Pos(x, y)) }
        visited[x][y] = true

        while (q.isNotEmpty()) {
            val (qx, qy) = q.removeFirst()
            for (i in dx.indices) {
                val nx = qx + dx[i]
                val ny = qy + dy[i]
                if (nx in 0 until M && ny in 0 until N){
                    if (field[nx][ny] == 1 && visited[nx][ny].not()) {
                        visited[nx][ny] = true
                        q.addLast(Pos(nx, ny))
                    }
                }
            }
        }
    }

}

fun main() {

    `1012`().solution()

}