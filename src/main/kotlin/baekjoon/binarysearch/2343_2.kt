package baekjoon.binarysearch

class `2343_2` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val B = readLine().split(" ").map(String::toInt)
        var (l, r) = B.maxOf { it } to B.sumOf { it }
        var answer = r
        while (l <= r) {
            val m = (l + r).div(2)
            var cnt = 1
            var left = 0
            for (b in B) {
                left += b
                if (left > m) {
                    left = b
                    cnt++
                }
            }

            if (cnt <= M) {
                r = m - 1
                answer = m
            } else {
                l = m + 1
            }
        }
        print(answer)
    }
}