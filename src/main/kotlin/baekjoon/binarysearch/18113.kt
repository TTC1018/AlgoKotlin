package baekjoon.binarysearch

class `18113` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K, M) = readLine().split(" ").map(String::toInt)
        var (l, r) = 1 to Int.MAX_VALUE
        val kimbap = List(N) { readLine().toInt() }
            .map { k ->
                when {
                    k >= 2*K -> k - 2*K
                    k in K+1 until 2*K -> k - K
                    else -> 0
                }
            }
            .also { kims -> r = kims.maxOf { it } }
            .filter { it > 0 }

        var answer = -1
        while (l <= r) {
            val m = (l + r).div(2)

            if (kimbap.sumOf { it / m } >= M) {
                l = m + 1
                answer = m
            } else {
                r = m - 1
            }
        }
        print(answer)
    }
}