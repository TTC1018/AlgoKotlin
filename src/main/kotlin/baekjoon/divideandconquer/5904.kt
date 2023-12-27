package baekjoon.divideandconquer

import kotlin.system.exitProcess

class `5904` {
    private val S = "moo"

    private fun search(len: Int, k: Int, target: Int) {
        val nextLen = (len * 2) + (k + 3)
        if (target <= 3) {
            print(S[target - 1])
            exitProcess(0)
        }

        if (nextLen < target) { // 아직 길이가 부족함
            search(nextLen, k + 1, target)
        } else {
            // 중앙 부분
            if (target in len + 1..len + k + 3) {
                if (target == len + 1) {
                    print(S.first())
                } else {
                    print(S.last())
                }
                exitProcess(0)
            } else { // 상위 부분 = 하위 부분 제거하고 분할정복
                search(3, 1, target - (len + k + 3))
            }
        }
    }

    // S[k] = S[k-1] + (m + o * (k+2)) + S[k-1]
    // -> 2*S[k-1] + (k+3)
    // 3, 10, 25, 56, ...
    // 2씩 곱하므로 10^9에 금방 도달할 듯
    // 분할 정복??
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        search(3, 1, N)
    }
}