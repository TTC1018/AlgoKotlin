package baekjoon.combination

import kotlin.math.absoluteValue

class `17471` {
    private var N = 0
    private lateinit var P: List<Int>
    private lateinit var G: List<List<Int>>
    private lateinit var checked: BooleanArray
    private var answer = Int.MAX_VALUE

    private fun choose(idx: Int, cnt: Int, limit: Int) {
        if (cnt == limit) {
            calculate()
            return
        }

        for (i in idx until N) {
            checked[i] = true
            choose(i + 1, cnt + 1, limit)
            checked[i] = false
        }
    }

    private fun calculate() {
        val visited = BooleanArray(N) { false }
        val (A, B) = (0 until N).partition { checked[it] }
        var (totalA, totalB) = 0 to 0

        val q = ArrayDeque<Int>().apply {
            totalA += P[A.first()]
            add(A.first())
            visited[A.first()] = true
        }
        while (q.isNotEmpty()) {
            val now = q.removeFirst()
            for (next in G[now]) {
                if (visited[next].not() && next in A) {
                    visited[next] = true
                    totalA += P[next]
                    q.add(next)
                }
            }
        }

        totalB += P[B.first()]
        q.add(B.first())
        visited[B.first()] = true
        while (q.isNotEmpty()) {
            val now = q.removeFirst()
            for (next in G[now]) {
                if (visited[next].not() && next in B) {
                    visited[next] = true
                    totalB += P[next]
                    q.add(next)
                }
            }
        }

        if (visited.all { it }) {
            answer = minOf(answer, (totalA - totalB).absoluteValue)
        }
    }


    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        P = readLine().split(" ").map(String::toInt)
        G = List(N) { readLine().split(" ").drop(1).map { it.toInt() - 1 } }

        checked = BooleanArray(N) { false }
        for (cnt in 1..N.div(2)) {
            choose(0, 0, cnt)
        }

        if (answer == Int.MAX_VALUE) {
            print(-1)
        } else {
            print(answer)
        }
    }
}