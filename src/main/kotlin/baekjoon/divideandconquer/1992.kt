package baekjoon.divideandconquer

class `1992` {

    private var answer = StringBuilder()
    private lateinit var graph: List<CharArray>

    enum class Result {
        NONE, ZERO, ONE
    }

    private fun check(x: Int, y: Int, width: Int): Result {

        var zeroFlag = true
        var oneFlag = true

        for (i in x until x + width) {
            for (j in y until y + width) {
                when (graph[i][j]) {
                    '0' -> oneFlag = false
                    '1' -> zeroFlag = false
                }
            }
        }

        return when {
            zeroFlag && oneFlag.not() -> Result.ZERO
            zeroFlag.not() && oneFlag -> Result.ONE
            else -> Result.NONE
        }
    }

    private fun dc(x: Int, y: Int, width: Int) {
        if (width == 1) {
            answer.append(graph[x][y])
            return
        }

        when (check(x, y, width)) {
            Result.ZERO -> {
                answer.append('0')
                return
            }
            Result.ONE -> {
                answer.append('1')
                return
            }
            else -> {
                val next = width / 2
                answer.append('(')
                dc(x, y, next)
                dc(x, y + next, next)
                dc(x + next, y, next)
                dc(x + next, y + next, next)
                answer.append(')')
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        graph = List(N) { readLine().toCharArray() }
        dc(0, 0, N)

        print(answer.toString())
    }

}

fun main() {

    `1992`().solution()

}