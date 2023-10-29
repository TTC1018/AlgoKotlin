package baekjoon.binarysearch

class `14627` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (S, C) = readLine().split(" ").map(String::toInt)
        val L = List(S) { readLine().toLong() }

        var (left, right) = 1L to L.maxOf { it }
        var answer = Long.MAX_VALUE
        while (left <= right) {
            val mid = (left + right) / 2 // 파

            val cnt = L.sumOf { it.div(mid) }
            if (cnt >= C) {
                left = mid + 1
                answer = mid
            } else {
                right = mid - 1
            }
        }
        print(L.sumOf { it } - answer * C)
    }
}