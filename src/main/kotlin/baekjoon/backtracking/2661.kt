package baekjoon.backtracking

import kotlin.system.exitProcess

class `2661` {
    private val answer = StringBuilder()
    private var N = 0

    // 전이랑 다르고
    // 전이랑 합친 게 이전 것들이랑 다르고
    // 전전까지 합친 게 이전 것들이랑 다르고....
    // 를 (인덱스+1)/2 까지 확인
    private fun backtracking(idx: Int) {
        if (idx == N) {
            print(answer)
            exitProcess(0)
        }

        loop@ for (n in 1..3) {
            answer.append(n)
            var l = 1
            var ptr = idx - 1
            while (l <= (idx + 1).div(2)) {
                val left = answer.slice((ptr - l + 1)..ptr)
                val right = answer.slice((idx - l + 1)..idx)
                if (left.contentEquals(right)) {
                    answer.deleteAt(answer.length - 1)
                    continue@loop
                }
                ptr--
                l++
            }
            backtracking(idx + 1)
            answer.deleteAt(answer.length - 1)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        backtracking(0)
    }
}