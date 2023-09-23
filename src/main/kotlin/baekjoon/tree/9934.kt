package baekjoon.tree

import kotlin.math.pow

class `9934` {
    private var K = 0
    private lateinit var B: IntArray
    private lateinit var answer: List<MutableList<Int>>
    private lateinit var visited: BooleanArray

    private fun dfs(now: Int, depth: Int) {
        if (depth == -1 || visited[now])
            return

        visited[now] = true
        answer[depth].add(B[now])

        val dist = (2.0).pow(depth - 1).toInt()
        dfs(now - dist, depth - 1)
        dfs(now + dist, depth - 1)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        K = readLine().toInt()
        B = readLine().split(" ").map(String::toInt).toIntArray()
        visited = BooleanArray(B.size) { false }
        answer = List(K) { mutableListOf() }
        dfs(((2.0).pow(K) - 1).div(2).toInt(), K - 1)
        print(answer.reversed().joinToString("\n") { it.joinToString(" ") })
    }
}

fun main() {
    `9934`().solution()
}