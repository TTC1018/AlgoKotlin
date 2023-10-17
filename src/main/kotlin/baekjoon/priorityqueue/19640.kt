package baekjoon.priorityqueue

import java.util.*

private var N = 0
private var M = 0
private var K = 0

class `19640` {

    private data class Worker(
        val num: Int,
        val d: Int,
        val h: Int
    ): Comparable<Worker> {
        override fun compareTo(other: Worker): Int {
            if (d == other.d && h == other.h)
                return (num % M).compareTo(other.num % M)
            else if (d == other.d)
                return other.h.compareTo(h)
            return other.d.compareTo(d)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = this[1]; K = last()
        }
        val W = List(N) { num -> readLine().split(" ").map(String::toInt).run { Worker(num, first(), last()) } }
        // 끝낼 타이밍 -> K

        val q = PriorityQueue<Worker>().apply {
            for (i in 0 until M.coerceAtMost(N)) {
                add(W[i])
            }
        }

        var answer = 0
        while (q.isNotEmpty()) {
            val (num, _, _) = q.remove()
            if (num == K) {
                print(answer)
                return
            }

            answer++
            if (num + M < N)
                q.add(W[num + M])
        }
        print(answer)
    }
}