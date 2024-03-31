package baekjoon.graph

class `3182` {
    private data class Next(
        val s: Int,
        val next: Int,
        val cnt: Int = 1,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nexts = List(N) { readLine().toInt() - 1 }
        val V = List(N) { BooleanArray(N) }
        val q = ArrayDeque<Next>().apply {
            nexts.forEachIndexed { i, v ->
                V[i][i] = true
                add(Next(i, v))
            }
        }
        var answer = Int.MAX_VALUE
        var answerVal = 0
        while (q.isNotEmpty()) {
            val (s, next, cnt) = q.removeFirst()

            if (V[s][next].not()) {
                V[s][next] = true
                q.add(Next(s, nexts[next], cnt + 1))
            } else {
                if (answerVal == cnt) {
                    answer = minOf(answer, s)
                } else if (answerVal < cnt) {
                    answerVal = cnt
                    answer = s
                }
            }
        }
        print(answer + 1)
    }
}