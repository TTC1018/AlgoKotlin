package baekjoon.shortestpath

class `11657_2` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val G = List(N) { LongArray(N) { Long.MAX_VALUE } }.apply {
            for (i in indices) this[i][i] = 0
        }
        repeat(M) {
            val (A, B, C) = readLine().split(" ").map(String::toInt)
            G[A - 1][B - 1] = minOf(G[A - 1][B - 1], C.toLong())
        }
        for (k in G.indices) {
            for (i in G.indices) {
                for (j in G.indices) {
                    if (G[i][k] != Long.MAX_VALUE && G[k][j] != Long.MAX_VALUE) {
                        G[i][j] = minOf(G[i][j], G[i][k] + G[k][j])
                    }
                }
            }
        }

        if ((0 until N).any { G[it][it] < 0 && G.first()[it] != Long.MAX_VALUE }) {
            print(-1)
        } else {
            print(G.first().drop(1).map { if (it == Long.MAX_VALUE) -1 else it }.joinToString("\n"))
        }
    }
}