package baekjoon.implementation

class `5212` {
    private data class Loc(
        val x: Int,
        val y: Int
    )

    private val d = listOf(
        Loc(-1, 0), Loc(0, 1), Loc(1, 0), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (R, C) = readLine().split(" ").map(String::toInt)
        val M = List(R) { readLine() }

        var (minX, maxX) = R to -1
        var (minY, maxY) = C to -1
        val countArray = List(R) { IntArray(C) }
        val answer = List(R) { CharArray(C) }
        repeat(R) { i ->
            repeat(C) { j ->
                if (M[i][j] == 'X') {
                    d.forEach { (dx, dy) ->
                        val (nx, ny) = i + dx to j + dy
                        if (nx in 0 until R && ny in 0 until C) {
                            if (M[nx][ny] == '.')
                                countArray[i][j]++
                        } else {
                            countArray[i][j]++
                        }
                    }

                    if (countArray[i][j] <= 2) {
                        answer[i][j] = 'X'
                        maxX = maxOf(maxX, i)
                        minX = minOf(minX, i)
                        maxY = maxOf(maxY, j)
                        minY = minOf(minY, j)
                    } else {
                        answer[i][j] = '.'
                    }
                } else {
                    answer[i][j] = '.'
                }
            }
        }

        for (i in minX..maxX) {
            for (j in minY..maxY) {
                print(answer[i][j])
            }
            println()
        }
    }
}


fun main() = with(System.`in`.bufferedReader()) {
    `5212`().solution()
}