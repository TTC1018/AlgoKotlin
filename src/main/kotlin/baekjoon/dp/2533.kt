package baekjoon.dp

class `2533` {

    private var N = 0
    private lateinit var dp: Array<IntArray>
    private lateinit var graph: List<MutableList<Int>>
    private lateinit var visited: BooleanArray

    private fun dfs(start: Int = 1) {

        graph[start].forEach { next ->
            if (visited[next].not()) {
                visited[next] = true
                dfs(next)
                dp[start][0] += dp[next][1]// 내가 얼리어댑터가 아니면 -> 다음이 얼리어댑터
                dp[start][1] += dp[next].minOf { it } // 내가 얼리어댑터면 -> 내 다음 노드 중 최소값 선택
            }
        }

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        N = readLine().toInt()
        dp = Array(N + 1) { intArrayOf(0, 1) } // 얼리어댑터 아닌 경우 | 맞는 경우
        graph = List(N + 1) { mutableListOf() }
        visited = BooleanArray(N + 1) { false }.also { it[1] = true }

        repeat(N - 1) {
            val (u, v) = readLine().split(" ").map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }

        dfs()

        println(dp[1].minOf { it })
    }

}

fun main() {

    `2533`().solution()

}