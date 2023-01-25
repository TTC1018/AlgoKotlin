package baekjoon.graph

import kotlin.math.min

class `2665` {

    private var n = 0
    private lateinit var board: Array<CharArray>
    private val d = listOf(Pos(0, 1), Pos(0, -1), Pos(1, 0), Pos(-1, 0))
    private val inRange: (Int, Int) -> Boolean = { x, y ->
        x in 0 until n && y in 0 until n
    }

    data class Pos(
        val x: Int,
        val y: Int,
        val cnt: Int = 0
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        n = readLine().toInt()
        board = Array(n) { readLine().toCharArray() }
        val visited = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        visited[0][0] = 0

        var answer = Int.MAX_VALUE
        val q = ArrayDeque<Pos>().apply { add(Pos(0, 0)) }
        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (x == n - 1 && y == n - 1){
                answer = min(answer, cnt)
                continue
            }

            d.forEach { (dx, dy) ->
                val nx = x + dx
                val ny = y + dy
                if (inRange(nx, ny)) {
                    when(board[nx][ny]) {
                        '0' -> {
                            if (cnt + 1 < visited[nx][ny]) {
                                visited[nx][ny] = cnt + 1
                                q.add(Pos(nx, ny, cnt + 1))
                            }
                        }
                        '1' -> {
                            if (cnt < visited[nx][ny]) {
                                visited[nx][ny] = cnt
                                q.add(Pos(nx, ny, cnt))
                            }
                        }
                    }
                }
            }
        }

        print(answer)
    }

}

fun main() {

    `2665`().solution()

}