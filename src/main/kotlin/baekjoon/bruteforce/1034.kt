package baekjoon.bruteforce

class `1034` {

    private var N = 0
    private var M = 0
    private lateinit var board: Array<IntArray>
    private var K = 0

    private fun searchOn(graph: Array<IntArray>): Int{
        for (row in N - 1 downTo 0){
            if (board[row].all { it == 1 })
                return row
        }
        return 0
    }

    fun solution() = with(System.`in`.bufferedReader()){

        readLine().split(" ").map { it.toInt() }
            .also { N = it.first(); M = it.last() }
        board = Array(N) { readLine().chunked(1).map { it.toInt() }.toIntArray() }
        K = readLine().toInt()



    }

}

fun main(){

    `1034`().solution()

}