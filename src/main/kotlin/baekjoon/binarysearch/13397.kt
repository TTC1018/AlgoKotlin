package baekjoon.binarysearch

class `13397` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toInt)

        var (l, r) = 0 to A.maxOf { it }
        var answer = r
        while (l <= r) {
            val m = (l + r).div(2)

            var cnt = 0
            var (minVal, maxVal) = A.first() to A.first()
            for (i in 1 until N) {
                minVal = minOf(minVal, A[i])
                maxVal = maxOf(maxVal, A[i])

                if (maxVal - minVal > m) {
                    cnt++
                    minVal = A[i]
                    maxVal = A[i]
                }
            }

            if (cnt < M) {
                r = m - 1
                answer = m
            } else {
                l = m + 1
            }
        }
        print(answer)
    }
}