package baekjoon.priorityqueue

import java.util.PriorityQueue

class `1379` {

    private data class Lecture(
        val num: Int,
        val start: Int,
        val end: Int
    )

    private data class EndAndRoom(
        val end: Int,
        val room: Int
    ) : Comparable<EndAndRoom> {
        override fun compareTo(other: EndAndRoom) = end.compareTo(other.end)
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val L = Array(N) { readLine().split(" ").map(String::toInt).let { Lecture(it[0] - 1, it[1], it[2]) } }
        L.sortWith(compareBy({ it.start }, { it.end }))
        val answer = IntArray(N)

        var roomNum = 1
        answer[L.first().num] = roomNum
        val q = PriorityQueue<EndAndRoom>().apply { add(EndAndRoom(L.first().end, roomNum)) }
        for (i in 1 until N) {
            if (q.isNotEmpty() && q.first().end <= L[i].start) {
                val (_, rNum) = q.remove()
                answer[L[i].num] = rNum
                q.offer(EndAndRoom(L[i].end, rNum))
            } else {
                roomNum++
                answer[L[i].num] = roomNum
                q.offer(EndAndRoom(L[i].end, roomNum))
            }
        }

        println(roomNum)
        print(answer.joinToString("\n"))
    }

}

fun main() {

    `1379`().solution()

}