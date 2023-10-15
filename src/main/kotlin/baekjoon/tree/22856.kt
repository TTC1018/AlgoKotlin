package baekjoon.tree

import kotlin.system.exitProcess

class `22856` {
    private var N = 0
    private lateinit var G: List<IntArray>
    private val inOrder = mutableListOf<Int>()
    private var answer = 0

    private fun findLast(now: Int) {
        val (l, r) = G[now]
        if (l != -1)
            findLast(l)
        inOrder.add(now)
        if (r != -1)
            findLast(r)
    }

    private fun dfs(now: Int) {
        if (G[now][0] != -1) {
            dfs(G[now][0])
            answer++
        }

        if (now == inOrder.last()) {
            print(answer)
            exitProcess(0)
        }
        answer++

        if (G[now][1] != -1) {
            dfs(G[now][1])
            answer++
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        G = List(N+1) { IntArray(2) { -1 } }.apply {
            repeat(N) {
                val (a, b, c) = readLine().split(" ").map(String::toInt)
                this[a][0] = b
                this[a][1] = c
            }
        }

        findLast(1)
        dfs(1)
        print(answer)
    }
}