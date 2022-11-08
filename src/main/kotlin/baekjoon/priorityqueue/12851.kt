package baekjoon.priorityqueue

import java.util.PriorityQueue

class `12851` {

    data class Pos(
        val x: Int,
        val count: Int
    ) : Comparable<Pos> {
        override fun compareTo(other: Pos): Int =
            this.count.compareTo(other.count)
    }

    private val pq = PriorityQueue<Pos>()

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, K) = readLine().split(" ").map { it.toInt() }
        val visited = BooleanArray(100000 + 1) { false }
        pq.add(Pos(N, 0))

        var answerVal = Int.MAX_VALUE
        var answerCnt = 0
        while (pq.isNotEmpty()) {
            val (now, count) = pq.remove()
            if (now == K) {
                when {
                    answerVal < count -> break
                    answerVal == count -> answerCnt++
                    answerVal == Int.MAX_VALUE -> {
                        answerVal = count
                        answerCnt++
                    }
                }
                continue
            }

            visited[now] = true
            if (now - 1 >= 0 && visited[now - 1].not()) {
                pq.add(Pos(now - 1, count + 1))
            }
            if (now + 1 <= 100000 && visited[now + 1].not()) {
                pq.add(Pos(now + 1, count + 1))
            }
            if (now * 2 <= 100000 && visited[now * 2].not()) {
                pq.add(Pos(now * 2, count + 1))
            }

        }

        print("$answerVal\n$answerCnt")
    }

}

fun main() {

    `12851`().solution()

}