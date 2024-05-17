package baekjoon.binarysearch

import kotlin.math.absoluteValue

class `27932` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, k) = readLine().split(" ").map(String::toInt)
        val H = readLine().split(" ").map(String::toInt)
        var (l, r) = 0 to H.maxOf { it }
        while (l <= r) {
            val m = (l + r).div(2)
            var cnt = 0
            for (i in H.indices) {
                val prev = (H[i] - (H.getOrNull(i - 1) ?: H[i])).absoluteValue
                val next = (H[i] - (H.getOrNull(i + 1) ?: H[i])).absoluteValue
                if (prev > m || next > m)
                    cnt++
            }

            if (cnt <= k) {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        print(l)
    }
}