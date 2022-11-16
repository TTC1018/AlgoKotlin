package baekjoon.topology

class `14567` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val nexts = List(N) { mutableListOf<Int>() }
        val indegree = IntArray(N) { 0 }
        val answers = IntArray(N) { 0 }
        repeat(M) {

            val (A, B) = readLine().split(" ").map { it.toInt() - 1 }
            indegree[B]++
            nexts[A].add(B)

        }

        val queue = ArrayDeque<Int>().apply {
            indegree.forEachIndexed { index, value ->
                if (value == 0) {
                    add(index)
                    answers[index] = 1
                }
            }
        }

        while (queue.isNotEmpty()) {
            val now = queue.removeFirst()

            for (next in nexts[now]) {
                indegree[next]--

                if (indegree[next] == 0) {
                    queue.addLast(next)
                    answers[next] = answers[now] + 1
                }
            }
        }

        print(answers.joinToString(" "))
    }

}

fun main() {

    `14567`().solution()

}