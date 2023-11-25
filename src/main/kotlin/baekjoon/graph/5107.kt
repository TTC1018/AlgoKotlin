package baekjoon.graph

class `5107` {
    private val graphMap = mutableMapOf<String, MutableList<String>>()
    private val visited = mutableSetOf<String>()

    fun solution() = with(System.`in`.bufferedReader()) {
        var order = 0
        while (true) {
            order++
            val N = readLine().toInt()
            if (N == 0)
                break

            graphMap.clear()
            visited.clear()
            repeat(N) {
                val (a, b) = readLine().split(" ")
                graphMap.getOrPut(a) { mutableListOf() }.add(b)
                graphMap.getOrPut(b) { mutableListOf() }.add(a)
            }

            var answer = 0
            for (name in graphMap.keys) {
                if (name !in visited) {
                    answer++
                    visited.add(name)
                    val q = ArrayDeque<String>().apply { add(name) }
                    while (q.isNotEmpty()) {
                        val now = q.removeFirst()
                        for (next in graphMap[now]!!) {
                            if (next !in visited) {
                                visited.add(next)
                                q.add(next)
                            }
                        }
                    }
                }
            }
            println("$order $answer")
        }
    }
}