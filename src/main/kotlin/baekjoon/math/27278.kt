package baekjoon.math

class `27278` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val t = readLine().split(" ").map(String::toLong)
        val P = (longArrayOf(0L) + t.toLongArray()).apply {
            for (i in 1..N)
                this[i] += this[i - 1]
        }
        var answer = 0L
        repeat(M) {
            var (p, r, c) = readLine().split(" ").map(String::toInt)
            p--; r--
            val journey = if (p <= r) P[r] - P[p] else P.last() - P[p] + P[r]
            val waiting = P[p] + (c - P[p] - 1).floorDiv(P.last()).plus(1).times(P.last())
            answer = maxOf(answer, journey + waiting)
        }
        print(answer)
    }
}