package baekjoon.binarysearch

import kotlin.math.ceil

class `17245` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = List(N) { readLine().split(" ").map(String::toLong) }
        val half = ceil(B.sumOf { row -> row.sumOf { it } }.toDouble().div(2)).toLong()
        var (l, r) = 0L to 10000000L
        var answer = r
        while (l <= r) {
            val m = (l + r).div(2)
            var cnt = 0L
            for (i in 0 until N) {
                for (j in 0 until N) {
                    cnt += minOf(B[i][j], m)
                }
            }

            if (cnt >= half) {
                r = m - 1
                answer = m
            } else {
                l = m + 1
            }
        }
        print(answer)
    }
}