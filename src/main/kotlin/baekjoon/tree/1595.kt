package baekjoon.tree

class `1595` {
    private lateinit var G: List<MutableList<Route>>
    private var minNum = Int.MAX_VALUE
    private var maxNum = 0
    private lateinit var dist: IntArray
    private lateinit var visited: BooleanArray

    private data class Route(
        val next: Int,
        val cost: Int
    )

    private fun dfs(now: Int, stacked: Int) {
        dist[now] = maxOf(dist[now], stacked)

        for ((next, cost) in G[now]) {
            if (visited[next].not()) {
                visited[next] = true
                dfs(next, stacked + cost)
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        G = List(10000 + 1) { mutableListOf<Route>() }
        while (true) {
            try {
                val (a, b, c) = readLine().split(" ").map(String::toInt)
                G[a].add(Route(b, c))
                G[b].add(Route(a, c))
                maxNum = maxOf(maxNum, a, b)
                minNum = minOf(minNum, a, b)
            } catch (e: Exception) {
                break
            }
        }

        // 도시가 하나라서 입력이 없는 경우가 있다.
        if (minNum == Int.MAX_VALUE && maxNum == 0) {
            print(0)
            return
        }

        // 아무 점에서나 가장 먼 위치 찾기
        dist = IntArray(maxNum + 1)
        visited = BooleanArray(maxNum + 1) { false }
        visited[minNum] = true
        dfs(minNum, 0)

        // 가장 먼 위치에서 가장 먼 위치 찾기
        val farthest = dist.withIndex().maxBy { it.value }.index
        dist = IntArray(maxNum + 1)
        visited = BooleanArray(maxNum + 1) { false }
        visited[farthest] = true
        dfs(farthest, 0)

        print(dist.maxOf { it })
    }
}

fun main() {
    `1595`().solution()
}