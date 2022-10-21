package baekjoon.priorityqueue

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

class `11000` {

    data class ClassInfo(
        val s: Int,
        val t: Int
    ):Comparable<ClassInfo> {

        override fun compareTo(other:ClassInfo):Int =
            this.t - other.t

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val infos = mutableListOf<ClassInfo>()
        repeat(N) {
            val (s, t) = readLine().split(" ").map { it.toInt() }
            infos.add(ClassInfo(s, t))
        }
        infos.sortWith(compareBy { it.s })

        var answer = 1
        val room = PriorityQueue<ClassInfo>().apply {
            add(infos[0])
        }

        for (i in 1 until N){
            val occupied = room.poll()

            if (infos[i].s < occupied.t){
                room.offer(occupied)
                room.offer(infos[i])
                answer++
            }
            else{
                room.offer(infos[i])
            }
        }

        println(answer)
    }

}

fun main() {

    `11000`().solution()

}