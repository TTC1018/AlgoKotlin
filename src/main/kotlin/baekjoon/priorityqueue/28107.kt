package baekjoon.priorityqueue

import java.util.*

class `28107` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val sushiQ = mutableMapOf<Int, PriorityQueue<Int>>().apply {
            repeat(N) { i ->
                readLine().split(" ").map(String::toInt).drop(1).forEach { sNum ->
                    this[sNum] = getOrElse(sNum) { PriorityQueue<Int>() }.also { it.add(i) }
                }
            }
        }

        val B = readLine().split(" ").map(String::toInt)
        val answer = IntArray(N)
        B.forEach {
            if (it in sushiQ && sushiQ[it]!!.isNotEmpty()) {
                answer[sushiQ[it]!!.remove()]++
            }
        }
        print(answer.joinToString(" "))
    }
}