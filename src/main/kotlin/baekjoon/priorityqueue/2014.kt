package baekjoon.priorityqueue

import java.util.*
import kotlin.math.max

class `2014` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (K, N) = readLine().split(" ").map { it.toInt() }

        val P = readLine().split(" ").map { it.toLong() }
        val q = PriorityQueue<Long>().apply { P.forEach { add(it) } }

        var popped = 0L
        repeat(N) {
            popped = q.remove()

            for (p in P) {

                val next = p * popped
                if (next >= Int.MAX_VALUE) // 최댓값은 Int범위-1
                    break

                q.add(next)
                if (popped % p == 0L) // 이미 등장한 숫자
                    break
            }
        }

        print(popped)
    }

}

fun main() {

    `2014`().solution()

}

