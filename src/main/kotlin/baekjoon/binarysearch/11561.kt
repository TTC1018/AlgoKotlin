package baekjoon.binarysearch

class `11561` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val N = readLine().toULong()
            var (l, r) = (1).toULong() to N
            var answer = l
            while (l <= r) {
                val m = (l + r).div(2u)
                if (m * (m + 1u) <= N.times(2u)) {
                    answer = m
                    l = m + 1u
                } else {
                    r = m - 1u
                }
            }
            sb.appendLine(answer)
        }
        print(sb.dropLast(1))
    }
}