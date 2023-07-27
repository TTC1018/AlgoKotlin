package baekjoon.graph

class `9466` {
    private lateinit var choice: IntArray
    private lateinit var visited: BooleanArray
    private var answer = 0

    private fun dfs(now: Int) {
        visited[now] = true
        val team = mutableSetOf(now)
        var node = now
        while (true) {
            node = choice[node]
            if (visited[node]) {
                answer += if (node in team) { // 싸이클 or 자기자신
                    team.indexOf(node)
                } else {
                    team.size
                }
                break
            } else {
                team.add(node)
                visited[node] = true
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        repeat(readLine().toInt()) {
            val n = readLine().toInt()
            choice = readLine().split(" ").map { it.toInt() - 1 }.toIntArray()
            visited = BooleanArray(n) { false }
            answer = 0

            for (start in 0 until n) {
                if (visited[start].not())
                    dfs(start)
            }
            println(answer)
        }
    }
}

fun main() {
    `9466`().solution()
}