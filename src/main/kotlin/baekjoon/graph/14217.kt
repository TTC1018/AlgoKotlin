package baekjoon.graph

class `14217` {
    data class Loc(
        val now: Int,
        val cnt: Int = 0
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, m) = readLine().split(" ").map(String::toInt)
        val graph = Array(n) { mutableSetOf<Int>() }
        repeat(m) {
            val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
            graph[a].add(b); graph[b].add(a)
        }

        val q = readLine().toInt()
        repeat(q) {
            val (a, i, j) = readLine().split(" ").map { it.toInt() - 1 }
            when (a) {
                0 -> {
                    graph[i].add(j); graph[j].add(i)
                }

                1 -> {
                    graph[i].remove(j); graph[j].remove(i)
                }
            }

            val visited = BooleanArray(n) { false }
            val queue = ArrayDeque<Loc>().apply { add(Loc(0)); visited[0] = true }
            val answer = IntArray(n) { -1 }.apply { this[0] = 0 }
            while (queue.isNotEmpty()) {
                val (now, cnt) = queue.removeFirst()

                for (next in graph[now]) {
                    if (visited[next].not()) {
                        visited[next] = true
                        answer[next] = cnt + 1
                        queue.add(Loc(next, cnt + 1))
                    }
                }
            }
            println(answer.joinToString(" "))
        }
    }
}

fun main() { `14217`().solution() }