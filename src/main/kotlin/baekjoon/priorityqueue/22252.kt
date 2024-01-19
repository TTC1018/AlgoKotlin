package baekjoon.priorityqueue

import java.util.*

class `22252` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val Q = readLine().toInt()
        val C = mutableMapOf<String, PriorityQueue<Long>>()
        var answer = 0L
        repeat(Q) {
            val query = readLine().split(" ")
            val op = query.first().toInt()
            val name = query[1]
            val infos = query.drop(2).map(String::toLong)
            if (op == 1) {
                C.getOrPut(name) { PriorityQueue(reverseOrder()) }.addAll(infos.drop(1))
            } else if (op == 2) {
                C[name]?.let {
                    for (i in 0 until infos.first()) {
                        if (it.isNotEmpty()) {
                            answer += it.remove()
                        } else {
                            break
                        }
                    }
                }
            }
        }
        print(answer)
    }
}