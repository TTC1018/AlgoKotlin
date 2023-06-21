package baekjoon.greedy

import kotlin.system.exitProcess

class `2141` {

    private data class Vill(
        val loc: Long,
        val num: Long
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val V = Array(N) { readLine().split(" ").map(String::toLong).let { Vill(it[0], it[1]) } }
            .sortedBy { it.loc }

        val half = V.sumOf { it.num }.let { if (it % 2 == 0L) it.div(2) else it.div(2) + 1 }
        var cnt = 0L
        for ((l, n) in V) {
            cnt += n

            if (cnt >= half) {
                print(l)
                exitProcess(0)
            }
        }
    }

}

fun main() {

    `2141`().solution()

}