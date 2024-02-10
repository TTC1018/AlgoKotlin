package baekjoon.graph

class `25512` {
    private var n = 0
    private lateinit var G: List<MutableList<Int>>
    private lateinit var C: List<List<Long>>

    private enum class Color {
        WHITE, BLACK
    }

    private fun search(prevColor: Color, now: Int): Long {
        if (G[now].isEmpty()) {
            return when(prevColor) {
                Color.WHITE -> C[now][Color.BLACK.ordinal]
                Color.BLACK -> C[now][Color.WHITE.ordinal]
            }
        }

        when(prevColor) {
            Color.WHITE -> {
                var result = C[now][Color.BLACK.ordinal]
                for (next in G[now]) {
                    result += search(Color.BLACK, next)
                }
                return result
            }
            Color.BLACK -> {
                var result = C[now][Color.WHITE.ordinal]
                for (next in G[now]) {
                    result += search(Color.WHITE, next)
                }
                return result
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        n = readLine().toInt()
        G = List(n) { mutableListOf() }
        repeat(n - 1) {
            val (p, c) = readLine().split(" ").map(String::toInt)
            G[p].add(c)
        }
        C = List(n) { readLine().split(" ").map(String::toLong) }
        print(minOf(search(Color.WHITE, 0), search(Color.BLACK, 0)))
    }
}