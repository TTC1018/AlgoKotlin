package baekjoon.tree

import kotlin.system.exitProcess

class `25511` {
    private var n = 0
    private var k = 0
    private lateinit var G: List<MutableList<Int>>
    private lateinit var V: List<Int>

    private fun dfs(now: Int, depth: Int) {
        if (V[now] == k) {
            print(depth)
            exitProcess(0)
        }

        for (next in G[now]) {
            dfs(next, depth + 1)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            n = first(); k = last()
        }
        G = List(n) { mutableListOf() }
        repeat(n - 1) {
            val (p, c) = readLine().split(" ").map(String::toInt)
            G[p].add(c)
        }
        V = readLine().split(" ").map(String::toInt)

        dfs(0, 0)
    }
}