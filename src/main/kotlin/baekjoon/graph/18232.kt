package baekjoon.graph

class `18232` {

    data class Loc(
        val x: Int,
        val cnt: Int = 0
    )

    private var N = 0
    private var M = 0
    private var S = 0
    private var E = 0
    private lateinit var teleport: Array<MutableList<Int>>
    private lateinit var visited: BooleanArray

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { N = it.first(); M = it.last() }
        readLine().split(" ").map { it.toInt() - 1 }
            .also { S = it.first(); E = it.last() }

        teleport = Array<MutableList<Int>>(N) { mutableListOf() }
            .also { t ->
                repeat(M) {
                    val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
                    t[x].add(y)
                    t[y].add(x)
                }
            }
        visited = BooleanArray(N) { false }

        val q = ArrayDeque<Loc>().apply { add(Loc(S, 0)) }
        while (q.isNotEmpty()) {

            val (now, time) = q.removeFirst()
            if (now == E) {
                print(time)
                return
            }

            if (now > 0 && visited[now - 1].not()){
                visited[now - 1] = true
                q.add(Loc(now - 1, time + 1))
            }

            if (now < N - 1 && visited[now + 1].not()){
                visited[now + 1] = true
                q.add(Loc(now + 1, time + 1))
            }

            for (t in teleport[now]) {
                if (visited[t].not()) {
                    visited[t] = true
                    q.add(Loc(t, time + 1))
                }
            }

        }
    }

}

fun main() {

    `18232`().solution()

}