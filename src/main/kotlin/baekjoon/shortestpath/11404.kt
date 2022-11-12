package baekjoon.shortestpath

class `11404` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val n = readLine().toInt()
        val m = readLine().toInt()
        val graph = Array(n) { IntArray(n) { 0 } }
        repeat(m) {
            var (a, b, c) = readLine().split(" ").map { it.toInt() }
            a -= 1; b -= 1
            if (graph[a][b] == 0 || c < graph[a][b])
                graph[a][b] = c
        }

        for (k in 0 until n){
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (graph[i][k] != 0 && graph[k][j] != 0){
                        val newDist = graph[i][k] + graph[k][j]
                        if (graph[i][j] == 0 || newDist < graph[i][j])
                            graph[i][j] = newDist
                    }
                }
            }
        }

        for (i in 0 until n)
            graph[i][i] = 0
        print(graph.joinToString("\n") { it.joinToString(" ") })
    }

}

fun main() {

    `11404`().solution()

}