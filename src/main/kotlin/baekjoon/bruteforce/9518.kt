package baekjoon.bruteforce

class `9518` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private val d = listOf(
        Loc(-1, -1), Loc(-1, 0), Loc(-1, 1),
        Loc(0, -1), Loc(0, 1),
        Loc(1, -1), Loc(1, 0), Loc(1, 1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (R, S) = readLine().split(" ").map(String::toInt)
        val B = List(R) { readLine() }
        val V = List(R) { BooleanArray(S) }
        val C = List(R) { IntArray(S) }
        for (i in 0 until R) {
            for (j in 0 until S) {
                if (B[i][j] == 'o') {
                    V[i][j] = true
                    for ((dx, dy) in d) {
                        val (nx, ny) = i + dx to j + dy
                        if (nx in 0 until R && ny in 0 until S) {
                            if (V[nx][ny].not()) {
                                C[nx][ny]++
                            }
                        }
                    }
                }
            }
        }
        var answer = 0
        var maxVal = 0
        for (i in 0 until R) {
            for (j in 0 until S) {
                if (B[i][j] == 'o') {
                    answer += C[i][j]
                } else {
                    maxVal = maxOf(maxVal, C[i][j])
                }
            }
        }
        print(answer + maxVal)
    }
}