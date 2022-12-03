package baekjoon.graph

class `10026` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    private val direc = arrayOf(
        Pos(1, 0), Pos(-1, 0),
        Pos(0, 1), Pos(0, -1)
    )

    private val targetColor = setOf('R', 'G')

    private fun bfs(
        x: Int,
        y: Int,
        graph: List<List<Char>>,
        visited: Array<BooleanArray>,
        isColorBind: Boolean = false
    ) {

        val queue = ArrayDeque<Pos>().apply { add(Pos(x, y)) }
        while (queue.isNotEmpty()) {
            val (qx, qy) = queue.removeFirst()

            for ((dx, dy) in direc) {
                val nx = qx + dx
                val ny = qy + dy

                if (nx in graph.indices && ny in graph.indices) {
                    when (isColorBind) {
                        true -> {
                            when (graph[x][y]) {
                                'B' -> {
                                    if (graph[nx][ny] == graph[x][y] && visited[nx][ny].not()) {
                                        visited[nx][ny] = true
                                        queue.addLast(Pos(nx, ny))
                                    }
                                }

                                'R', 'G' -> {
                                    if (graph[nx][ny] in targetColor && visited[nx][ny].not()) {
                                        visited[nx][ny] = true
                                        queue.addLast(Pos(nx, ny))
                                    }
                                }
                            }
                        }

                        false -> {
                            if (graph[nx][ny] == graph[x][y] && visited[nx][ny].not()) {
                                visited[nx][ny] = true
                                queue.addLast(Pos(nx, ny))
                            }
                        }
                    }
                }
            }
        }

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val graph = List(N) { readLine().toList() }
        var visited = Array(N) { BooleanArray(N) { false } }

        // Normal
        var answerOne = 0
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (visited[i][j].not()) {
                    answerOne++
                    visited[i][j] = true
                    bfs(i, j, graph, visited)
                }
            }
        }

        // Color-bind
        visited = Array(N) { BooleanArray(N) { false } }
        var answerTwo = 0
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (visited[i][j].not()) {
                    answerTwo++
                    visited[i][j] = true
                    bfs(i, j, graph, visited, true)
                }
            }
        }

        print("$answerOne $answerTwo")
    }

}

fun main() {

    `10026`().solution()

}