package baekjoon.graph

class `1726` {

    data class Pos(
        val x: Int,
        val y: Int,
        val dNum: Int = -1,
        val cnt: Int = 0
    )

    private lateinit var board: Array<IntArray>
    private val d = listOf(
        Pos(0, 1), Pos(0, -1),
        Pos(1, 0), Pos(-1, 0)
    )
    private val turn = buildMap {
        put(0, arrayOf(2, 3))
        put(1, arrayOf(3, 2))
        put(2, arrayOf(0, 1))
        put(3, arrayOf(1, 0))
    }

    private val oppo = buildMap {
        put(0, 1)
        put(1, 0)
        put(2, 3)
        put(3, 2)
    }

    private lateinit var start: Pos
    private lateinit var end: Pos
    private lateinit var inRange: (Int, Int) -> Boolean
    private lateinit var visited: Array<Array<BooleanArray>>

    fun solution() = with(System.`in`.bufferedReader()) {

        val (M, N) = readLine().split(" ").map { it.toInt() }
        board = Array(M) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        inRange = { x, y -> x in 0 until M && y in 0 until N }
        visited = Array(M) { Array(N) { BooleanArray(4) { false } } }
        start = readLine().split(" ").map { it.toInt() - 1 }.run { Pos(this[0], this[1], this[2]) }
        end = readLine().split(" ").map { it.toInt() - 1 }.run { Pos(this[0], this[1], this[2]) }

        val q = ArrayDeque<Pos>().apply {
            visited[start.x][start.y][start.dNum] = true
            add(Pos(start.x, start.y, start.dNum, 0))
        }

        while (q.isNotEmpty()){
            val (x, y, dNum, cnt) = q.removeFirst()
            if (x == end.x && y == end.y && dNum == end.dNum){
                print(cnt)
                return
            }

            // 직진
            var nx = x
            var ny = y
            for(i in 1..3) {
                nx += d[dNum].x
                ny += d[dNum].y

                if (inRange(nx, ny) && board[nx][ny] == 0){
                    if (visited[nx][ny][dNum].not()){
                        visited[nx][ny][dNum] = true
                        q.add(Pos(nx, ny, dNum, cnt + 1))
                    }
                }
                else
                    break
            }

            // 좌 우
            turn[dNum]!!.forEach {
                if (visited[x][y][it].not()){
                    visited[x][y][it] = true
                    q.add(Pos(x, y, it, cnt + 1))
                }
            }

            // 뒤로 돌기
            if (visited[x][y][oppo[dNum]!!].not()){
                visited[x][y][oppo[dNum]!!] = true
                q.add(Pos(x, y, oppo[dNum]!!, cnt + 2))
            }
        }
    }

}

fun main() {

    `1726`().solution()

}