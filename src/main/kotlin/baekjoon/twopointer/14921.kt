package baekjoon.twopointer

import kotlin.math.absoluteValue

class `14921` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val A = readLine().split(" ").map(String::toLong)
        // 투포인터?
        // 다 양수 or 음수라면 절댓값 가장 작은 걸로
        // 섞여있다면?
        // -101 93 -> 8
        // -3 93 -> 90
        // -3 5 -> 2
        // -3 -1 break
        var answer = Long.MAX_VALUE
        var answerAbsol = Long.MAX_VALUE
        var (l, r) = 0 to N-1
        while (l < r) {
            val diff = A[l] + A[r]
            if (diff.absoluteValue < answerAbsol) {
                answerAbsol = diff.absoluteValue
                answer = diff
            }

            if (diff == 0L) {
                answer = 0L
                break
            } else if (diff < 0) {
                l++
            } else {
                r--
            }
        }
        print(answer)
    }
}