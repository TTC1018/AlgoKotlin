package baekjoon.graph


class `1600` {

    data class Pos(
        val x: Int,
        val y: Int,
        val count: Int = 0,
        val horse: Int = 0
    )

    private val oneStep = arrayOf(Pos(1, 0), Pos(-1, 0), Pos(0, 1), Pos(0, -1))
    private val horseStep = arrayOf(
        Pos(-2, 1), Pos(-2, -1), Pos(1, 2), Pos(1, -2),
        Pos(-1, -2), Pos(-1, 2), Pos(2, -1), Pos(2, 1)
    )


    fun solution() = with(System.`in`.bufferedReader()) {

        val K = readLine().toInt()
        val (W, H) = readLine().split(" ").map { it.toInt() }
        val graph = Array(H) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
        val visited = Array(H) { Array(W) { BooleanArray(K + 1) { false } } } // 0은 onsStep, 1은 horseStep으로 온 경우
        visited[0][0][0] = true

        val queue = ArrayDeque<Pos>().apply { add(Pos(0, 0)) }
        while (queue.isNotEmpty()) {
            val (qx, qy, count, horse) = queue.removeFirst()
            if (qx == H - 1 && qy == W - 1) {
                print(count)
                return
            }

            for (oStep in oneStep) {
                val nx = qx + oStep.x
                val ny = qy + oStep.y
                if (nx in 0 until H && ny in 0 until W) {
                    if (graph[nx][ny] == 0 && visited[nx][ny][horse].not()) {
                        visited[nx][ny][horse] = true
                        queue.addLast(Pos(nx, ny, count + 1, horse))
                    }
                }
            }

            if (horse < K) {
                for (hStep in horseStep) {
                    val nx = qx + hStep.x
                    val ny = qy + hStep.y
                    if (nx in 0 until H && ny in 0 until W) {
                        if (graph[nx][ny] == 0 && visited[nx][ny][horse + 1].not()) {
                            visited[nx][ny][horse + 1] = true
                            queue.addLast(Pos(nx, ny, count + 1, horse + 1))
                        }
                    }
                }
            }
        }

        print(-1)
    }

}

fun main() {

    `1600`().solution()

}