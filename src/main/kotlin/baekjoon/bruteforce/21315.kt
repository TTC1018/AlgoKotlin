package baekjoon.bruteforce

import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

class `21315` {
    private var N = 0
    private lateinit var C: IntArray
    private lateinit var T: IntArray

    private fun shuffle(k: Int, cnt: Int) {
        if (k < 0)
            return

        val cardNum = (2.0).pow(k).toInt()
        val endIdx = if (cnt == 0) N - 1 else cardNum * 2 - 1
        val next = C.clone()
        (0 until cardNum).zip(endIdx - cardNum + 1..endIdx) { i, j ->
            next[i] = C[j]
        }
        (cardNum..endIdx).zip(if (cnt == 0) (0 until N - cardNum) else ((0 until cardNum))) { i, j ->
            next[i] = C[j]
        }

        C = next
        shuffle(k - 1, cnt + 1)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        T = readLine().split(" ").map(String::toInt).toIntArray()
        // K -> 9까지 가능
        // 최대 10단계
        // 1023 * 1000 * (9 * 9) -> 1억 미만
        val maxK = ceil(log2(N.toDouble())).toInt()
        for (k1 in 1 until maxK) {
            C = IntArray(N) { it + 1 }
            shuffle(k1, 0)
            val saved = C.clone()
            for (k2 in 1 until maxK) {
                C = saved
                shuffle(k2, 0)
                if (C.contentEquals(T)) {
                    print("$k1 $k2")
                    return
                }
            }
        }
    }
}

fun main() {
    `21315`().solution()
}