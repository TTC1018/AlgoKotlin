package baekjoon.binarysearch

class `16564` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var N: Int
        var K: Long
        readLine().split(" ").run {
            N = first().toInt(); K = last().toLong()
        }
        val X = List(N) { readLine().toLong() }
        var (l, r) = X.minOf { it } to 1000000000L + K
        var answer = r
        while (l <= r) {
            val m = (l + r).div(2)

            if (K >= X.sumOf { (m - it).coerceAtLeast(0) }) {
                l = m + 1
                answer = m
            } else {
                r = m - 1
            }
        }
        print(answer)
    }
}