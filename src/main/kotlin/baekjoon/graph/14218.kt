package baekjoon.graph

class `14218` {
    private var n = 0
    private var m = 0
    private lateinit var answer: IntArray
    private lateinit var road: List<MutableList<Int>>

    private fun dfs(now: Int, cnt: Int) {
        val jump = mutableListOf<Int>()
        for (next in road[now]) {
            if (answer[next] == -1 || cnt < answer[next]) {
                answer[next] = cnt
                jump.add(next)
            }
        }

        for (next in jump) {
            dfs(next, cnt + 1)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().trim().split(" ").map(String::toInt).run {
            n = first(); m = last();
        }
        answer = IntArray(n) { -1 }.apply { this[0] = 0 }
        road = List<MutableList<Int>>(n) { mutableListOf() }.apply {
            repeat(m) {
                val (x, y) = readLine().trim().split(" ").map { it.toInt() - 1 }
                this[x].add(y)
                this[y].add(x)
            }
        }
        dfs(0, 1)
        val sb = StringBuilder()
        repeat(readLine().trim().toInt()) {
            val (i, j) = readLine().trim().split(" ").map { it.toInt() - 1 }
            road[i].add(j)
            road[j].add(i)
            if (answer[i] != -1) {
                dfs(i, answer[i] + 1)
            }
            if (answer[j] != -1) {
                dfs(j, answer[j] + 1)
            }
            sb.append(answer.joinToString(" ")).append("\n")
        }
        print(sb)
    }
}