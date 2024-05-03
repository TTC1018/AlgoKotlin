package baekjoon.greedy

import java.util.*

class `23254` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toInt)
        val B = readLine().split(" ").map(String::toInt)
        val ab = A.zip(B).sortedByDescending { it.second }
        var answer = A.sumOf { it }.toLong()
        var left = 24 * N
        val prev = PriorityQueue<Int>(reverseOrder())
        for ((a, b) in ab) {
            while (left > 0 && prev.isNotEmpty() && prev.first() >= b) {
                answer += prev.remove()
                left--
            }

            if (left == 0)
                break

            val limit = (100 - a) / b
            val space = (100 - a) % b
            val can = limit.coerceAtMost(left)
            answer += b * can
            left -= can
            prev.add(space)
        }

        while (left > 0 && prev.isNotEmpty()) {
            answer += prev.remove()
            left--
        }
        print(answer)
    }
}