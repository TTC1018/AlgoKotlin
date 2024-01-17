package baekjoon.disjointset

class `20955` {
    private var N = 0
    private var M = 0
    private lateinit var P: IntArray

    private fun findParent(x: Int): Int {
        if (P[x] != x)
            P[x] = findParent(P[x])
        return P[x]
    }

    private fun unionParent(a: Int, b: Int) {
        val pa = findParent(a)
        val pb = findParent(b)

        if (pa < pb) {
            P[pb] = pa
        } else if (pa > pb) {
            P[pa] = pb
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        P = IntArray(N) { it }
        var answer = 0
        repeat(M) {
            readLine().split(" ").map { it.toInt() - 1 }.run {
                if (findParent(first()) == findParent(last())) {
                    answer++ // 사이클은 유지시키지만 끊었다고 가정
                }
                unionParent(first(), last())
            }
        }
        for (n in 0 until N-1) {
            if (findParent(n) != findParent(n+1)) {
                unionParent(n, n + 1)
                answer++
            }
        }
        print(answer)
    }
}