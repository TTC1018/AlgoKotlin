package baekjoon.implementation

class `31747` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val q = List(2) { ArrayDeque<Int>() }
        readLine().split(" ").map(String::toInt).withIndex().partition { it.value == 1 }.run {
            q.first().addAll(first.map { it.index })
            q.last().addAll(second.map { it.index })
        }

        var answer = 0
        var s = 0
        while (q.all { it.isNotEmpty() }) {
            when {
                q[0][0] < s + K && q[1][0] < s + K -> {
                    q.forEach { it.removeFirst() }
                    s += 2
                }
                q[0][0] < s + K -> {
                    q.first().removeFirst()
                    s++
                }
                else -> {
                    q.last().removeFirst()
                    s++
                }
            }
            answer++
        }
        print(answer + q.sumOf { it.size })
    }
}