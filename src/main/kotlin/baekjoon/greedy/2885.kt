package baekjoon.greedy

import kotlin.math.log2
import kotlin.math.pow

class `2885` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var K = readLine().toInt()
        if (K.countOneBits() == 1) {
            print("$K 0")
            return
        }

        val n = kotlin.math.floor(log2(K.toFloat())).toInt()
        var M = (2.0).pow(n).toInt()
        val fm = M * 2
        var answer = 0
        while (K > 0) {
            if (K >= M) {
                K -= M
            }
            answer++
            M = M shr 1
        }
        print("$fm $answer")
    }
}