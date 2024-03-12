package baekjoon.prefixsum

class `12847` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map(String::toInt)
        val T = readLine().split(" ").map(String::toLong)
        val P = LongArray(n).apply {
            this[0] = T.first()
            for (i in 1 until n) {
                this[i] += (this[i-1] + T[i])
            }
        }
        var answer = P[m - 1]
        for (i in m until n) {
            answer = maxOf(answer, P[i] - P[i - m])
        }
        print(answer)
    }
}