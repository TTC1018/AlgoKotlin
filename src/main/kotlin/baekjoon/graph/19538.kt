package baekjoon.graph

import kotlin.math.ceil

class `19538` {

    private var N = 0
    private lateinit var F: Array<IntArray>
    private var M = 0

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        F = Array(N) { readLine().split(" ").map { it.toInt() - 1 }.dropLast(1).toIntArray() }
        M = readLine().toInt()
        val answer = IntArray(N) { -1 }
        val counter = IntArray(N) { 0 }
        var q = mutableListOf<Int>().apply { addAll(readLine().split(" ").map { it.toInt() - 1 }) }
        for (first in q) answer[first] = 0

        var sec = 1
        while (q.isNotEmpty()) {
            val next = mutableListOf<Int>()
            for (now in q) {
                for (nxt in F[now]) {
                    if (answer[nxt] == -1) {
                        counter[nxt]++
                        if (counter[nxt] >= ceil(F[nxt].size.toDouble() / 2)) {
                            answer[nxt] = sec
                            next.add(nxt)
                        }
                    }
                }
            }
            sec++

            q = next
        }
        print(answer.joinToString(" "))
    }
}

fun main() {
    `19538`().solution()
}