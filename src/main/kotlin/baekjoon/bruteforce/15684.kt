package baekjoon.bruteforce

import kotlin.math.min

class `15684` {

    private var N = 0
    private var M = 0
    private var H = 0
    private lateinit var T: Array<BooleanArray>
    private var answer = 1e9.toInt()

    private fun bruteforce(y: Int, cnt: Int) {
        if (cnt > 3)
            return

        if (laddering()) {
            answer = min(answer, cnt)
            return
        }

        for (j in y until H) {
            for (i in 0 until N - 1) {
                if (T[j][i].not()) {
                    T[j][i] = true
                    bruteforce(j, cnt + 1)
                    T[j][i] = false
                }
            }
        }
    }

    private fun laddering(): Boolean {

        for (start in 0 until N) {
            var x = start;
            var y = 0
            while (y < H) {
                when {
                    x > 0 && T[y][x - 1] -> x--
                    x < N - 1 && T[y][x] -> x++
                }
                y++
            }

            if (start != x)
                return false
        }

        return true
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map(String::toInt)
            .also { N = it[0]; M = it[1]; H = it[2] }
        T = Array(H) { BooleanArray(N - 1) { false } }
        if (M > 0) {

            repeat(M) {
                val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
                T[a][b] = true
            }
        }

        bruteforce(0, 0)
        print(if (answer == 1e9.toInt()) -1 else answer)
    }

}

fun main() {

    `15684`().solution()

}