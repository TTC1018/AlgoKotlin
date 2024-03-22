package baekjoon.graph

class `24483` {
    private var N = 0
    private var M = 0
    private var R = 0
    private lateinit var G: List<MutableList<Long>>
    private lateinit var T: LongArray
    private lateinit var D: LongArray
    private var order = 1L

    private fun dfs(now: Int, depth: Long) {
        for (next in G[now]) {
            val nxt = next.toInt()
            if (D[nxt] == -1L) {
                T[nxt] = ++order
                D[nxt] = depth + 1
                dfs(nxt, depth + 1)
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = this[1]; R = last() - 1
        }
        G = List(N) { mutableListOf() }
        repeat(M) {
            val (u, v) = readLine().split(" ").map { it.toLong() - 1 }
            G[u.toInt()].add(v)
            G[v.toInt()].add(u)
        }
        G.forEach { it.sort() }

        D = LongArray(N) { -1L }
        T = LongArray(N) { 0L }
        D[R] = 0L
        T[R] = 1L
        dfs(R, 0L)
        print(T.zip(D).sumOf { (t, d) -> t * d })
    }
}