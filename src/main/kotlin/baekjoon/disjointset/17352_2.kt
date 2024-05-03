package baekjoon.disjointset

class `17352_2` {
    private lateinit var P: IntArray

    private fun union(a: Int, b: Int) {
        val (pa, pb) = find(a) to find(b)
        if (pa > pb) {
            P[pa] = pb
        } else if (pa < pb) {
            P[pb] = pa
        }
    }

    private fun find(x: Int): Int {
        if (P[x] != x) {
            P[x] = find(P[x])
        }
        return P[x]
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        P = IntArray(N) { it }
        repeat(N - 2) {
            val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
            union(a, b)
        }

        print(
            P.filterIndexed { i, v -> i == v }
                .joinToString(" ") { "${it + 1}" }
        )
    }
}