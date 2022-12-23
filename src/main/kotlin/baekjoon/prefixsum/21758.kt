package baekjoon.prefixsum

import kotlin.math.max

// 도착지는 오른쪽 끝이 아닐 수도 있다
// 도착지가 중간에 있다면 -> 출발지는 좌 우 끝
// 도착지가 끝에 있다면 -> 출발지는 반대쪽에

class `21758` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val locs = readLine().split(" ").map { it.toInt() }
        val sumVals = IntArray(N) { 0 }.also {
            it[0] = locs[0]
            for (i in 1 until N){
                it[i] = it[i - 1] + locs[i]
            }
        }
        val sumValsReversed = IntArray(N) { 0 }.also {
            it[N - 1] = locs.last()
            for (i in N - 2 downTo 0){
                it[i] = it[i + 1] + locs[i]
            }
        }

        var answer = 0
        // 도착지가 끝
        // 오른쪽 끝
        for (i in 1 until N - 1){ // 두번째 지점 후보
            val first = sumVals.last() - locs.first() - locs[i]
            val second = sumVals.last() - sumVals[i]

            answer = max(answer, first + second)
        }
        // 왼쪽 끝
        for (i in N - 2 downTo  1){
            val first = sumValsReversed.first() - locs.last() - locs[i]
            val second = sumValsReversed.first() - sumValsReversed[i]

            answer = max(answer, first + second)
        }

        // 도착지가 중간
        for (i in 1 until N - 1){ // 중간지점 후보
            val left = sumVals[i] - sumVals.first()
            val right = sumValsReversed[i] - sumValsReversed.last()

            answer = max(answer, left + right)
        }

        print(answer)
    }

}

fun main() {

    `21758`().solution()

}