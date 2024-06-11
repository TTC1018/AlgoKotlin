package baekjoon.graph

class `21316` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val G = List(12 + 1) { mutableListOf<Int>() }.apply {
            repeat(12) {
                val (x, y) = readLine().split(" ").map(String::toInt)
                this[x].add(y)
                this[y].add(x)
            }
        }
        val ordered = listOf(1, 2, 3)
        val counter = G.map { it.map { next -> G[next].size } }
        print(counter.indexOfFirst { it.size == 3 && it.sorted() == ordered })
    }
}