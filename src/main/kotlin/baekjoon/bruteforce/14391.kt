package baekjoon.bruteforce

import kotlin.math.max

class `14391` {

    private lateinit var horizontal: List<BooleanArray>
    private lateinit var graph: List<List<Int>>
    private var N = 0
    private var M = 0
    private var answer = 0

    private fun backTracking(x: Int, y: Int) {
        if (x == N - 1 && y == M - 1) {
            var sumVal = 0

            // 가로 종이 더하기
            for (i in 0 until N) {
                var j = 0
                while (j < M) {
                    var temp = graph[i][j].toString()
                    if (horizontal[i][j]) {
                        var tempIdx = j + 1
                        while (tempIdx < M && horizontal[i][tempIdx]) {
                            temp += graph[i][tempIdx].toString()
                            tempIdx++
                        }
                        sumVal += temp.toInt()
                        j = tempIdx
                    } else
                        j++
                }
            }

            // 세로 종이 더하기
            for (j in 0 until M) {
                var i = 0
                while (i < N) {
                    var temp = graph[i][j].toString()
                    if (horizontal[i][j].not()) {
                        var tempIdx = i + 1
                        while (tempIdx < N && horizontal[tempIdx][j].not()) {
                            temp += graph[tempIdx][j].toString()
                            tempIdx++
                        }
                        sumVal += temp.toInt()
                        i = tempIdx
                    } else
                        i++
                }
            }

            answer = max(answer, sumVal)
            return
        }


        if (y == M - 1){
            horizontal[x + 1][0] = true
            backTracking(x + 1, 0)
            horizontal[x + 1][0] = false
            backTracking(x + 1, 0)
        }
        else{
            horizontal[x][y + 1] = true
            backTracking(x, y + 1)
            horizontal[x][y + 1] = false
            backTracking(x, y + 1)
        }


    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val NM = readLine().split(" ").map { it.toInt() }
        N = NM[0]; M = NM[1]
        horizontal = List(N) { BooleanArray(M) { false } }
        graph = List(N) { readLine().chunked(1).map { it.toInt() } }

        horizontal[0][0] = true
        backTracking(0, 0)
        horizontal[0][0] = false
        backTracking(0, 0)

        println(answer)
    }

}

fun main() {

    `14391`().solution()

}