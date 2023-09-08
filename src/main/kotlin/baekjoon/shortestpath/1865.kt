package baekjoon.shortestpath

private const val INF = 1e9.toInt()

class `1865` {
    private data class Route(
        val s: Int,
        val e: Int,
        val t: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        var tc = readLine().toInt()
        loop@ while (tc-- > 0) {
            val (N, M, W) = readLine().split(" ").map(String::toInt)
            val R = buildList {
                repeat(M) {
                    readLine().split(" ").map(String::toInt).run {
                        add(Route(this[0] - 1, this[1] - 1, this[2]))
                        add(Route(this[1] - 1, this[0] - 1, this[2]))
                    }
                }
            } + List(W) {
                readLine().split(" ").map(String::toInt).run {
                    Route(this[0] - 1, this[1] - 1, -this[2])
                }
            }

            val dist = IntArray(N) { INF }.apply { this[0] = 0 }
            for(i in 0 until N) {
                for (j in 0 until M * 2 + W) {
                    val (now, next, cost) = R[j]
                    val newDist = dist[now] + cost
                    if (newDist < dist[next]) {
                        dist[next] = newDist
                        if (i == N - 1) {
                            println("YES")
                            continue@loop
                        }
                    }
                }
            }

            println("NO")
        }
    }
}

fun main() {
    `1865`().solution()
}