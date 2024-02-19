package baekjoon.implementation

class `20207` {
    private data class Date(
        val S: Int,
        val E: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val D = List(N) { readLine().split(" ").map(String::toInt).run { Date(first(), last()) } }
            .sortedWith(compareBy({ it.S }, { -(it.E - it.S + 1) }))

        val B = List(N) { BooleanArray(365 + 1) { false } }
        for ((S, E) in D) {
            for (row in 0 until N) {
                if ((S..E).all { B[row][it].not() }) {
                    B[row].fill(true, S, E + 1)
                    break
                }
            }
        }

        var height = 0
        var width = 0
        var answer = 0
        for (n in 1..365) {
            val clang = (0 until N).any { B[it][n] }
            val maxHeight = ((0 until N).findLast { B[it][n] } ?: -1) + 1

            height = maxOf(height, maxHeight)
            if (clang) {
                width++
            } else {
                answer += (width * height)
                width = 0
                height = 0
            }
        }

        if (width != 0) {
            answer += (width * height)
        }
        print(answer)
    }
}