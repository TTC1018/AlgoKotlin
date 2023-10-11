package baekjoon.graph

class `11266` {
    private var V = 0
    private var E = 0
    private var order = 1
    private lateinit var G: List<MutableList<Int>>
    private lateinit var visited: IntArray
    private lateinit var answer: BooleanArray

    private fun dfs(now: Int, isRoot: Boolean = false): Int {
        visited[now] = order++ // 방문 순서 기록

        var childCnt = 0 // 자식 노드 개수를 센다
        var minNum = visited[now] // 자식 노드에 더 빠른 순서가 있다면 기록할 변수
        for (next in G[now]) { // 인접 정점 탐색
            if (visited[next] == 0) { // 자식 노드
                childCnt++
                minNum = minOf(minNum, dfs(next, false)
                    .run {
                        // 자식 노드보다 현재 노드의 순서가 앞선다면 단절점이 된다.
                        if (isRoot.not() && visited[now] <= this) {
                            answer[now] = true
                        }
                        this
                    }
                )
            } else { // 인접 노드
                // 이미 방문한 적 있는 인접 노드라면 순서만 비교한다.
                minNum = minOf(minNum, visited[next])
            }
        }

        // 루트면서 자식 노드 개수 2개 이상이면 이 또한 단절점이다.
        if (isRoot && childCnt >= 2) {
            answer[now] = true
        }
        return minNum // 자신과 인접 노드의 순서 중 가장 빠른 순서
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
        answer = BooleanArray(V + 1) { false }

        for (v in 1..V) {
            if (visited[v] == 0)
                dfs(v, true)
        }

        println(answer.count { it })
        println(answer.withIndex().filter { it.value }.joinToString(" ") { it.index.toString() })
    }
}

fun main() {
    `11266`().solution()
}