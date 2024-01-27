package baekjoon.queue

import java.util.PriorityQueue
import kotlin.collections.ArrayDeque

class `22234` {

    private data class Client(
        val P: Int,
        val t: Int,
    )

    private data class Waiting(
        val P: Int,
        val t: Int,
        val c: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, T, W) = readLine().split(" ").map(String::toInt)
        val C = ArrayDeque<Client>().apply {
            repeat(N) {
                add(readLine().split(" ").map(String::toInt).run { Client(first(), last()) })
            }
        }
        val M = readLine().toInt()
        val wq = PriorityQueue<Waiting>(compareBy { it.c }).apply {
            repeat(M) {
                add(readLine().split(" ").map(String::toInt).let { Waiting(it[0], it[1], it[2]) })
            }
        }

        val answer = mutableListOf<Int>()
        var now = 0
        while (C.isNotEmpty()) {
            val (P, t) = C.removeFirst()
            val next = mutableListOf<Client>()
            if (t > T) {
                answer.addAll(List(T) { P })
                next.add(Client(P, t - T))
                now += T
            } else {
                answer.addAll(List(t) { P })
                now += t
            }

            while (wq.isNotEmpty() && wq.first().c <= now) {
                C.addLast(wq.remove().let { Client(it.P, it.t) })
            }
            C.addAll(next)
        }
        print(answer.slice(0 until W).joinToString("\n"))
    }
}