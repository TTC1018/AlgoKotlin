package baekjoon.priorityqueue

import java.util.*

class `23843` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val t = PriorityQueue<Int>(reverseOrder()).apply {
            addAll(readLine().split(" ").map(String::toInt))
        }
        // 가장 긴 것부터 꽂아야 다른 콘센트가 회전이 됨
        val c = PriorityQueue<Int>().apply {
            repeat(minOf(N, M)) {
                add(t.remove())
            }
        }

        var time = 0
        while (t.isNotEmpty()) {
            val endOfNow = c.remove()
            time = endOfNow
            while (c.isNotEmpty() && c.first() == time) {
                c.remove()
            }
            while (t.isNotEmpty() && c.size < M) {
                c.add(time + t.remove())
            }
        }

        while (c.isNotEmpty()) {
            time = c.remove()
        }
        print(time)
    }
}