package baekjoon.greedy

class `5911` {
    private data class Gift(
        val P: Long,
        val S: Long,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, B) = readLine().split(" ").map(String::toLong)
        val G = List(N.toInt()) { readLine().split(" ").map(String::toLong).run { Gift(first(), last()) } }
        var cnt = 0
        for (i in G.indices) {
            val newG = G.run { slice(0 until i) + slice(i + 1 until G.size) + listOf(Gift(G[i].P / 2, G[i].S)) }
                .map { it.P + it.S }
                .sortedBy { it }

            val P = LongArray(G.size).apply {
                this[0] = newG.first()
                for (j in 1 until G.size) this[j] += this[j - 1] + newG[j]
            }
            if (P.last() <= B) {
                print(N)
                return
            } else {
                cnt = maxOf(cnt, P.indexOfFirst { it > B })
            }
        }
        print(cnt)
    }
}