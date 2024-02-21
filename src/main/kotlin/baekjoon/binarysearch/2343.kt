package baekjoon.binarysearch

class `2343` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val L = readLine().split(" ").map(String::toLong)
        // 차이가 가장 적도록 M 등분하기
        // N^2 불가능, logN 한번은 해야됨
        // 가능한 값 -> 최소값 ~ 합 사이
        var answer = L.sumOf { it }
        var (l, r) = L.maxOf { it } to answer
        while (l <= r) {
            val m = (l + r).div(2)

            var left = M
            var sumVal = 0L
            for (i in 0 until N) {
                sumVal += L[i]
                if (sumVal > m) {
                    sumVal = L[i]
                    left--
                }
            }

            if (left > 0) {
                r = m - 1
                answer = m
            } else {
                l = m + 1
            }
        }
        print(answer)
    }
}