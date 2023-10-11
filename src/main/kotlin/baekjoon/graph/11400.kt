package baekjoon.graph

class `11400` {
    private data class Edge(
        val x: Int,
        val y: Int,
    ):Comparable<Edge> {
        override fun toString() = "$x $y"
        override fun compareTo(other: Edge): Int {
            if (x == other.x)
                return y.compareTo(other.y)
            return x.compareTo(other.x)
        }
    }

    private var V = 0
    private var E = 0
    private var order = 1 // 방문 순서 기록
    private lateinit var G: List<MutableList<Int>>
    private lateinit var visited: IntArray
    private val answer: MutableList<Edge> = mutableListOf()

    private fun dfs(now: Int, prev: Int): Int {
        visited[now] = order++

        var minNum = visited[now]
        for (next in G[now]) {
            if (next != prev) {
                minNum = if (visited[next] == 0) { // 방문 안 한 노드라면
                    minOf(minNum, dfs(next, now)
                        .run {
                            if (visited[now] < this) { // 자식 노드보다 방문 순서가 앞선다면
                                // 단절점과 다르게 == 비교가 없는 이유는 점이 아니라 선이기 때문이다
                                // 자신과 같은 순서 값을 리턴한 점이 있다면 그 선을 제거해도 다른 선이 존재할 수 밖에 없다.
                                answer.add(Edge(minOf(now, next), maxOf(now, next)))
                            }
                            this
                        }
                    )
                } else { // 이미 방문한 노드라면 순서만 비교
                    minOf(minNum, visited[next])
                }
            }
        }

        return minNum
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            V = first(); E = last()
        }
        G = List<MutableList<Int>>(V + 1) { mutableListOf() }.apply {
            repeat(E) {
                val (a, b) = readLine().split(" ").map(String::toInt)
                this[a].add(b)
                this[b].add(a)
            }
        }
        visited = IntArray(V + 1)

        dfs(1, -1)
        answer.sort()
        println(answer.size)
        print(answer.joinToString("\n"))
    }
}

fun main() {
    `11400`().solution()
}