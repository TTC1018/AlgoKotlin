package baekjoon.priorityqueue

import java.util.*

class `17503` {
    private data class Beer(
        val v: Int,
        val c: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, K) = readLine().split(" ").map(String::toInt)
        val B = List(K) { readLine().split(" ").map(String::toInt).run { Beer(first(), last()) } }
            .sortedBy { it.c }
        var answer = -1
        val pq = PriorityQueue<Int>()
        var total = 0
        for ((v, c) in B) {
            pq.add(v)
            total += v

            if (pq.size > N) {
                total -= pq.remove()
            }

            if (pq.size == N && total >= M) {
                answer = c
                break
            }
        }

        print(answer)
    }
}