package baekjoon.implementation

import kotlin.math.max

class `17144` {

    data class Pos(
        val x: Int,
        val y: Int
    )

    private var R = 0
    private var C = 0
    private var T = 0
    private lateinit var board: Array<IntArray>
    private val direc = listOf(
        Pos(-1, 0), Pos(1, 0), Pos(0, -1), Pos(0, 1)
    )
    private var airPos = Array(2) { Pos(0, 0) }
    private val inRange: (Int, Int) -> Boolean = { x, y ->
        x in 0 until R && y in 0 until  C
    }

    private fun sumDust(): Int {
        var result = 0

        for (i in 0 until R){
            for (j in 0 until C){
                result += max(board[i][j], 0)
            }
        }

        return result
    }

    private fun cleaning() {

        val (up, down) = airPos
        val result = Array(R) { IntArray(C) }
            .also {
                it[up.x][up.y] = -1
                it[down.x][down.y] = -1
            }

        var (ux, uy) = Pos(up.x, up.y + 1)
        var (dx, dy) = Pos(down.x, down.y + 1)
        // 위 반시계방향
        while (uy != C - 1){
            result[ux][uy + 1] += max(board[ux][uy], 0)
            uy += 1
        }
        while (ux != 0){
            result[ux - 1][uy] += max(board[ux][uy], 0)
            ux -= 1
        }
        while (uy != 0){
            result[ux][uy - 1] += max(board[ux][uy], 0)
            uy -= 1
        }
        while (ux != up.x - 1){
            result[ux + 1][uy] += max(board[ux][uy], 0)
            ux += 1
        }

        // 아래 시계방향
        while (dy != C - 1){
            result[dx][dy + 1] += max(board[dx][dy], 0)
            dy += 1
        }
        while (dx != R - 1){
            result[dx + 1][dy] += max(board[dx][dy], 0)
            dx += 1
        }
        while (dy != 0){
            result[dx][dy - 1] += max(board[dx][dy], 0)
            dy -= 1
        }
        while (dx != down.x + 1){
            result[dx - 1][dy] += max(board[dx][dy], 0)
            dx -= 1
        }

        for (i in 1 until up.x){
            for (j in 1 until C - 1){
                result[i][j] = board[i][j]
            }
        }

        for (i in down.x + 1 until R - 1){
            for (j in 1 until C - 1){
                result[i][j] = board[i][j]
            }
        }

        board = result
    }

    private fun spread() {
        val (up, down) = airPos
        val result = Array(R) { IntArray(C) }
            .also {
                it[up.x][up.y] = -1
                it[down.x][down.y] = -1
            }

        for (i in 0 until R){
            for (j in 0 until C){
                if (board[i][j] > 0){
                    var dust = board[i][j]
                    direc.forEach { (dx, dy) ->
                        val nx = i + dx
                        val ny = j + dy

                        if (inRange(nx, ny) && board[nx][ny] != -1){
                            result[nx][ny] += (board[i][j].div(5))
                            dust -= (board[i][j].div(5))
                        }
                    }
                    result[i][j] += dust
                }
            }
        }

        board = result
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { R = it[0]; C = it[1]; T = it[2] }
        board = Array(R) { readLine().split(" ").map { it.toInt() }.toIntArray() }
            .also {
                for (i in 0 until R) {
                    if (it[i][0] == -1) {
                        airPos = arrayOf(Pos(i, 0), Pos(i + 1, 0))
                        break
                    }
                }
            }

        repeat(T) {
            spread()
            cleaning()
        }
        print(sumDust())
    }

}

fun main() {

    `17144`().solution()

}