package baekjoon.disjointset

class `20040` {
    private var n = 0
    private var m = 0
    private lateinit var P: IntArray

    private fun findParent(x: Int): Int {
        if (P[x] != x)
            P[x] = findParent(P[x])
        return P[x]
    }

    private fun unionParent(a: Int, b: Int) {
        val (pa, pb) = findParent(a) to findParent(b)

        if (pa < pb) {
            P[pb] = pa
        } else if (pa > pb) {
            P[pa] = pb
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            n = first(); m = last()
            P = IntArray(n) { it }
        }

        var answer = n+1
        repeat(m) {
            readLine().split(" ").map(String::toInt).run {
                if (findParent(first()) != findParent(last())) {
                    unionParent(first(), last())
                } else {
                    answer = minOf(answer, it + 1)
                }
            }
        }
        if (answer == n+1)
            print(0)
        else
            print(answer)
    }
}