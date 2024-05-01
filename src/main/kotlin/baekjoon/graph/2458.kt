package baekjoon.graph

class `2458` {
    private var N = 0
    private var M = 0
    private lateinit var C: List<MutableList<Int>>
    private lateinit var P: List<MutableList<Int>>
    private lateinit var V: BooleanArray

    private fun searchChild(now: Int): Int {
        V[now] = true
        var sumVal = 1
        for (child in C[now]) {
            if (V[child].not()) {
                sumVal += searchChild(child)
            }
        }
        return sumVal
    }

    private fun searchParent(now: Int): Int {
        V[now] = true
        var sumVal = 1
        for (parent in P[now]) {
            if (V[parent].not()) {
                sumVal += searchParent(parent)
            }
        }
        return sumVal
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        C = List(N) { mutableListOf() }
        P = List(N) { mutableListOf() }
        V = BooleanArray(N) { false }
        repeat(M) {
            val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
            P[a].add(b)
            C[b].add(a)
        }

        val counts = IntArray(N)
        for (n in 0 until N) {
            V.fill(false)
            counts[n] = searchChild(n) + searchParent(n) - 2
        }

        print(counts.count { it == N - 1 })
    }
}