package baekjoon.sorting

class `23889` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, K) = readLine().split(" ").map(String::toInt)
        val V = readLine().split(' ').map(String::toInt)
        val S = readLine().split(" ").map { it.toInt() - 1 }
        val P = IntArray(N).apply {
            this[0] = V.first()
            for (i in 1 until N) {
                this[i] += this[i - 1] + V[i]
            }
        }
        val damage = IntArray(K).apply {
            S.zipWithNext().forEachIndexed { i, (a, b) ->
                this[i] = P[b] - V[b] - (P.getOrNull(a - 1) ?: 0)
            }
            this[K - 1] = P.last() - P[S.last() - 1]
        }.mapIndexed { i, v -> IndexedValue(S[i], v) }
            .sortedWith(compareBy({ -it.value }, { it.index }))

        print(
            damage.slice(0 until M)
                .sortedBy { it.index }
                .joinToString("\n") { "${it.index + 1}" }
        )
    }
}