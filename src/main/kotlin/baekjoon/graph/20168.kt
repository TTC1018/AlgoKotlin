package baekjoon.graph

class `20168` {
    private data class Route(
        val next: Int,
        val cost: Int,
    )

    private data class Loc(
        val x: Int,
        val v: Int,
        val left: Int,
        val maxVal: Int = -1,
    )

    private fun Int.toBit() = (1 shl this)

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, A, B, C) = readLine().split(' ').map(String::toInt)
        val G = List(N + 1) { mutableListOf<Route>() }.apply {
            repeat(M) {
                val (x, y, c) = readLine().split(" ").map(String::toInt)
                this[x].add(Route(y, c))
                this[y].add(Route(x, c))
            }
        }
        val q = ArrayDeque<Loc>().apply {
            add(Loc(A, A.toBit(), C))
        }

        var answer = Int.MAX_VALUE
        while (q.isNotEmpty()) {
            val (x, v, left, maxVal) = q.removeFirst()
            if (x == B) {
                answer = minOf(answer, maxVal)
                continue
            }

            for ((next, cost) in G[x]) {
                if (v and next.toBit() == 0 && left >= cost) {
                    q.add(Loc(next, v or next.toBit(), left - cost, maxOf(maxVal, cost)))
                }
            }
        }

        if (answer == Int.MAX_VALUE) {
            print(-1)
        } else {
            print(answer)
        }
    }
}