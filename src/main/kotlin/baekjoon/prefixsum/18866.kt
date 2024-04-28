package baekjoon.prefixsum

class `18866` {
    private data class Day(
        val u: Int,
        val v: Int,
    )

    fun main() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val D = List(N) { readLine().split(" ").map(String::toInt).run { Day(first(), last()) } }
        val Y = List(N + 1) { intArrayOf(Int.MAX_VALUE, 0) }
        val O = List(N + 2) { intArrayOf(0, Int.MAX_VALUE) }
        for (i in 1..N) {
            Y[i][0] = Y[i - 1][0]
            Y[i][1] = Y[i - 1][1]
            if (D[i - 1].u != 0)
                Y[i][0] = minOf(Y[i][0], D[i - 1].u)
            if (D[i - 1].v != 0)
                Y[i][1] = maxOf(Y[i][1], D[i - 1].v)
        }
        for (i in N downTo 1) {
            O[i][0] = O[i + 1][0]
            O[i][1] = O[i + 1][1]
            if (D[i - 1].u != 0)
                O[i][0] = maxOf(O[i][0], D[i - 1].u)
            if (D[i - 1].v != 0)
                O[i][1] = minOf(O[i][1], D[i - 1].v)
        }
        var answer = -1
        for (i in 1 until N) {
            if (Y[i][0] >= O[i + 1][0] && Y[i][1] <= O[i + 1][1]) {
                answer = i
            }
        }
        print(answer)
    }
}