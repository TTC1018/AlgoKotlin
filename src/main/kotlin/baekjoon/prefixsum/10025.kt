package baekjoon.prefixsum

class `10025` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val P = LongArray(1000000 + 2).apply {
            repeat(N) {
                readLine().split(" ").let {
                    this[it.last().toInt() + 1] = it.first().toLong()
                }
            }
            for (i in 1..1000001) {
                this[i] += this[i-1]
            }
        }
        var answer = 0L
        for (i in 1..1000001) {
            answer = maxOf(answer, P[(i + K).coerceAtMost(1000001)] - P[(i - K - 1).coerceAtLeast(0)])
        }
        print(answer)
    }
}