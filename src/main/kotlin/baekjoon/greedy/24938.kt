package baekjoon.greedy

import kotlin.math.absoluteValue

class `24938` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toLong).toLongArray()
        // A를 N으로 나눈 값이 되어야 함
        val target = A.sumOf { it } / N
        var answer = 0L
        for (i in 0 until A.lastIndex) {
            val diff = (A[i] - target).absoluteValue
            answer += diff
            when {
                A[i] > target -> A[i + 1] += diff
                A[i] < target -> A[i + 1] -= diff
            }
        }
        print(answer)
    }
}