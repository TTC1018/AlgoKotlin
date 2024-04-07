package baekjoon.math

class `16502` {
    private data class Route(
        val next: String,
        val prob: Float,
    )

    private var T = 0
    private var M = 0
    private val G = mutableMapOf<String, MutableList<Route>>()
    private val answer = mutableMapOf<String, Float>().apply {
        put("A", 0f); put("B", 0f); put("C", 0f); put("D", 0f)
    }

    private fun calc(now: String, prob: Float, cnt: Int) {
        if (cnt == T) {
            answer[now] = answer.getOrDefault(now, 0f) + prob
            return
        }

        for ((next, p) in G[now]!!) {
            calc(next, prob * p, cnt + 1)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        T = readLine().toInt()
        M = readLine().toInt()
        repeat(M) {
            val (x, y, p) = readLine().split(" ")
            G.getOrPut(x) { mutableListOf() }.add(Route(y, p.toFloat()))
        }
        listOf("A", "B", "C", "D").forEach {
            calc(it, 1f, 0)
        }
        print(answer.values.joinToString("\n") { "%.2f".format(it / 4 * 100) })
    }
}