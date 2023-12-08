package baekjoon.binarysearch

import kotlin.math.ceil

class `2792` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val J = List(M) { readLine().toInt() }
        // 같은 색상의 보석만 가져감
        // 보석을 최대한 균등하게 나눠주기
        var (l, r) = 1L to J.maxOf { it }.toLong()
        var answer = r
        while (l <= r) {
            val m = (l + r).div(2)
            var cnt = 0
            for (j in J) {
                cnt += ceil(j.toDouble().div(m)).toInt()
            }

            if (cnt <= N) {
                r = m - 1
                answer = m
            } else {
                l = m + 1
            }
        }
        print(answer)
    }
}