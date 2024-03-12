package baekjoon.binarysearch

class `13702` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val M = List(N) { readLine().toLong() }

        var (l, r) = 1L to M.maxOf { it }
        var answer = 0L
        while (l <= r) {
            val m = (l + r).div(2)

            var cnt = 0L
            for (mak in M) {
                cnt += mak.div(m)
            }

            if (cnt >= K) {
                l = m + 1
                answer = m
            } else {
                r = m - 1
            }
        }
        print(answer)
    }
}