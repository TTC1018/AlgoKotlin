package baekjoon.greedy

class `1911` {
    private data class Swamp(
        val s: Int,
        val e: Int,
    )


    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, L) = readLine().split(" ").map(String::toInt)
        val S = List(N) { readLine().split(" ").map(String::toInt).run { Swamp(first(), last()) } }
            .sortedBy { it.s }
        var answer = 0L
        var lastEnd = S.first().s
        for (i in S.indices) {
            lastEnd = lastEnd.coerceAtLeast(S[i].s)
            if (lastEnd < S[i].e) {
                val gap = (S[i].e.toDouble() - lastEnd)
                val boardCount = kotlin.math.ceil(gap.div(L)).toInt()
                lastEnd += boardCount * L
                answer += boardCount
            }
        }
        print(answer)
    }
}