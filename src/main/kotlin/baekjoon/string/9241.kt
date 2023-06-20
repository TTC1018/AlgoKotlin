package baekjoon.string

import kotlin.math.max

class `9241` {

    fun solution() = with(System.`in`.bufferedReader()) {
        val prev = readLine()
        val after = readLine()
        var (pIdx, aIdx) = listOf(0, 0)
        var left = 0
        while (pIdx < prev.length && aIdx < after.length) {
            if (prev[pIdx] != after[aIdx])
                break
            pIdx++; aIdx++; left++
        }

        pIdx = prev.length - 1; aIdx = after.length - 1
        var right = 0
        while (pIdx >= 0 && aIdx >= 0) {
            if (prev[pIdx] != after[aIdx])
                break
            pIdx--; aIdx--; right++
        }
        print(maxOf(max(0, after.length - prev.length), after.length - (left + right)))
    }

}

fun main() {

    `9241`().solution()

}