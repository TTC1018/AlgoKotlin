package baekjoon.bitmasking

import kotlin.math.pow

class `18119` {

    private fun Char.toIdx() = (1 shl this - 'a')

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map(String::toInt)
        val S = Array(N) { readLine() }
        var activated = (2.0.pow(26) - 1).toInt()
        val counter = IntArray(N)

        for (i in S.indices) {
            for (c in S[i]) {
                val bit = c.toIdx()
                counter[i] = counter[i] or bit
            }
        }

        repeat(M) {

            val (o, x) = readLine().split(" ")
            activated = activated xor x[0].toIdx()
            println(counter.count { it and activated == it })

        }
    }

}

fun main() {

    `18119`().solution()

}