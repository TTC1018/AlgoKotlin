package baekjoon.greedy

import kotlin.math.pow

class `1339` {
    private fun Char.toIdx() = this - 'A'

    fun main() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val words = List(N) { readLine() }
        val counter = IntArray('Z' - 'A' + 1)
        for (word in words) {
            for (i in word.indices) {
                counter[word[i].toIdx()] += (10.0).pow(word.length - i - 1).toInt()
            }
        }
        counter.sortDescending()
        print(counter.slice(0 until 10).mapIndexed { i, v -> (9 - i) * v }.sumOf { it })
    }
}