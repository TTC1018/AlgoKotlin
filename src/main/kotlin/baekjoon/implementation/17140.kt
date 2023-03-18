package baekjoon.implementation

import kotlin.math.max

class `17140` {

    private var r = 0
    private var c = 0
    private var k = 0
    private lateinit var board: MutableList<MutableList<Int>>

    private fun shouldEnd(board:List<List<Int>>):Boolean{
        if (r < board.size && c < board.first().size){
            if (board[r][c] == k)
                return true
        }
        return false
    }

    private fun countedList(row: List<Int>):MutableList<Int> =
        row.groupingBy { it }
            .eachCount().toMutableMap().apply { remove(0) }
            .toList().sortedWith(compareBy({it.second}, {it.first}))
            .flatMap { listOf(it.first, it.second) }.toMutableList()


    private fun fillZero(row:MutableList<Int>, maxLen:Int) {
        row.addAll(MutableList(maxLen - row.size) { 0 })
    }

    fun solution() = with(System.`in`.bufferedReader()){

        readLine().split(" ").map { it.toInt() }
            .also { r = it[0] - 1; c = it[1] - 1; k = it[2] }
        board = MutableList(3) { readLine().split(" ").map { it.toInt() }.toMutableList() }

        for (cnt in 0..100){
            if (shouldEnd(board)){
                print(cnt)
                return
            }

            var maxLen = 0
            when {
                board.size >= board.first().size -> {
                    for (i in 0 until board.size){
                        board[i] = countedList(board[i])
                        maxLen = max(maxLen, board[i].size)
                    }
                    // 0 채우기
                    for (i in 0 until board.size){
                        fillZero(board[i], maxLen)
                    }

                }
                else -> {
                    val copy = MutableList(board.first().size) { mutableListOf<Int>() }
                    // 행열 뒤집기
                    for (j in 0 until board.first().size){
                        for (i in 0 until board.size){
                            copy[j].add(board[i][j])
                        }
                    }

                    for (i in 0 until copy.size){
                        copy[i] = countedList(copy[i])
                        maxLen = max(maxLen, copy[i].size)
                    }

                    // 0 채우기
                    for (i in 0 until copy.size){
                        fillZero(copy[i], maxLen)
                    }

                    // 행열 다시 뒤집기
                    board = MutableList(copy.first().size) { MutableList(copy.size) { 0 } }
                    for (j in 0 until board.first().size){
                        for (i in 0 until board.size){
                            board[i][j] = copy[j][i]
                        }
                    }
                }
            }

        }


        print(-1)
    }

}

fun main() {

    `17140`().solution()

}