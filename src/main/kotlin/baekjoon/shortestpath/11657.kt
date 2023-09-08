package baekjoon.shortestpath

private const val INF = 1e9.toLong()

class `11657` {
    private data class Route(
        val s: Int,
        val e: Int,
        val t: Long
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)

        val R = List(M) {
            readLine().split(" ").map(String::toInt).run {
                Route(this[0] - 1, this[1] - 1, this[2].toLong())
            }
        }

        val dist = LongArray(N) { INF }.apply { this[0] = 0 }
        for (i in 0 until N) {
            for (j in 0 until M) {
                val (now, next, cost) = R[j]

                val newDist = dist[now] + cost
                if (dist[now] != INF && newDist < dist[next]) {
                    dist[next] = newDist
                    if (i == N - 1) { // 마지막까지도 줄어드는 구간 = 음수 간선 무한 순환
                        print(-1)
                        return
                    }
                }
            }
        }

        for (i in 1 until N) {
            if (dist[i] == INF)
                println(-1)
            else
                println(dist[i])
        }
    }
}

fun main() {
    `11657`().solution()
}