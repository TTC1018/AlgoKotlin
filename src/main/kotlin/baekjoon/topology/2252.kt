package baekjoon.topology

class `2252` {

    fun solution() = with(System.`in`.bufferedReader()){

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val indegree = IntArray(N) { 0 }
        val graph = Array(N) { mutableListOf<Int>() }.also { g ->
            repeat(M) {
                val (A, B) = readLine().split(" ").map { it.toInt() }
                g[A - 1].add(B - 1)
                indegree[B - 1]++
            }
        }

        val q = ArrayDeque<Int>().apply {
            indegree.forEachIndexed { index, value -> if (value == 0) add(index) }
        }

        val answer = mutableListOf<Int>()
        while (q.isNotEmpty()){
            val now = q.removeFirst()
            answer.add(now + 1)

            for (next in graph[now]){
                indegree[next]--

                if (indegree[next] == 0)
                    q.add(next)
            }
        }

        println(answer.joinToString(" "))
    }

}

fun main() {

    `2252`().solution()

}