package baekjoon.bruteforce

import kotlin.math.max

class `3085` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    private var N = 0
    private lateinit var board: Array<CharArray>

    private val inRange: (Int, Int) -> Boolean = { x, y ->
        x in 0 until N && y in 0 until N
    }

    private val d = listOf(Pos(0, 1), Pos(1, 0))

    private fun calc():Int{
        var result = 0
        // 행탐색
        for (idx in 0 until N){
            var y = 1
            var count = 1
            var prev = board[idx].first()
            while (y < N){
                if (board[idx][y] == prev){
                    count++
                }
                else{
                    result = max(result, count)
                    count = 1
                }
                prev = board[idx][y]
                y++
            }
            result = max(result, count)

            // 열탐색
            var x = 1
            count = 1
            prev = board[0][idx]
            while (x < N){
                if (board[x][idx] == prev){
                    count++
                }
                else{
                    result = max(result, count)
                    count = 1
                }
                prev = board[x][idx]
                x++
            }
            result = max(result, count)
        }

        return result
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        board = Array(N) { readLine().toCharArray() }
        var answer = 0

        for (i in 0 until N) {
            for (j in 0 until N) {
                d.forEach { (dx, dy) ->
                    val nx = i + dx
                    val ny = j + dy

                    if (inRange(nx, ny) && board[i][j] != board[nx][ny]){
                        board[i][j] = board[nx][ny].also { board[nx][ny] = board[i][j] }
                        answer = max(answer, calc())
                        board[i][j] = board[nx][ny].also { board[nx][ny] = board[i][j] }
                    }
                }
            }
        }

        print(answer)
    }

}

fun main() {

    `3085`().solution()

}