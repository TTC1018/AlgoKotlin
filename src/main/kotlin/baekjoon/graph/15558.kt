package baekjoon.graph

import kotlin.system.exitProcess

class `15558` {
    private var N = 0
    private var k = 0
    private lateinit var LR: List<List<Int>>
    private lateinit var V: List<BooleanArray>

    private fun dfs(where: Int, idx: Int, time: Int) {
        if (idx >= N) {
            print(1)
            exitProcess(0)
        }

        if (idx < 0 || idx < time || V[where][idx] || LR[where][idx] == 0)
            return

        V[where][idx] = true
        dfs(where, idx - 1, time + 1)
        dfs((where + 1) % 2, idx + k, time + 1)
        dfs(where, idx + 1, time + 1)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); k = last()
        }
        LR = List(2) { readLine().map(Char::digitToInt) }
        V = List(2) { BooleanArray(N) { false } }
        dfs(0, 0, 0)
        print(0)
    }
}