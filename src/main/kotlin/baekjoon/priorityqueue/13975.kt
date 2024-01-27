package baekjoon.priorityqueue

import java.util.PriorityQueue

class `13975` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val K = readLine().toInt()
            val q = PriorityQueue<Long>().apply {
                addAll(readLine().split(" ").map(String::toLong))
            }
            var answer = 0L

            while (q.size > 1) {
                val (x, y) = q.remove() to q.remove()
                answer += (x + y)
                q.add(x + y)
            }
            sb.append(answer).append('\n')
        }
        print(sb.dropLast(1))
    }
}