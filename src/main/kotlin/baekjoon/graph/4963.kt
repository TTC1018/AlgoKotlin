package baekjoon.graph

class `4963` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        while (true) {
            var answer = 0
            val (w, h) = readLine().split(" ").map { it.toInt() }
            if (w == 0 && h == 0)
                break

            val graph = Array(h) {  readLine().split(" ").map { it.toInt() }.toTypedArray()  }
            val visited = Array(h) { Array(w) {false} }

            for (i in 0 until h) {
                for (j in 0 until w) {
                    if (graph[i][j] == 1 && visited[i][j].not()) {
                        answer++
                        visited[i][j] = true
                        bfs(i, j, w, h, graph, visited)
                    }
                }
            }

            println(answer)
        }
    }

    private val direc = listOf(
        Pos(0, -1), Pos(0, 1), Pos(1, 1),
        Pos(1, 0), Pos(-1, 0), Pos(1, -1),
        Pos(-1, 1), Pos(-1, -1)
    )

    private fun bfs(
        x: Int,
        y: Int,
        w: Int,
        h: Int,
        graph: Array<Array<Int>>,
        visited: Array<Array<Boolean>>
    ) {
        val q = ArrayDeque<Pos>().apply { add(Pos(x, y)) }
        while (q.isNotEmpty()) {
            val (px, py) = q.removeFirst()

            for ((dx, dy) in direc) {
                val nx = px + dx
                val ny = py + dy
                if (nx in 0 until h && ny in 0 until w) {
                    if (graph[nx][ny] == 1 && visited[nx][ny].not()) {
                        visited[nx][ny] = true
                        q.addLast(Pos(nx, ny))
                    }
                }
            }
        }
    }
}

fun main() {

    `4963`().solution()

}