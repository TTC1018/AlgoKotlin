package baekjoon.priorityqueue


import java.util.PriorityQueue


class `22867` {
    private data class Bus(
        val s: Int,
        val e: Int
    )

    private data class EndAndRoom(
        val e: Int,
        val r: Int
    ): Comparable<EndAndRoom> {
        override fun compareTo(other: EndAndRoom) = e.compareTo(other.e)
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = Array(N) {
            readLine().split(" ")
                .map { it.split(":").map { n -> n.toDouble() } }
                .map { it[0] * 3600 * 1000 + it[1] * 60 * 1000 + it[2] * 1000 }
                .let { Bus(it[0].toInt(), it[1].toInt()) }
        }.sortedArrayWith(compareBy({ it.s }, { it.e }))
        
        var rNum = 1
        val q = PriorityQueue<EndAndRoom>().apply { add(EndAndRoom(B.first().e, rNum)) }
        for (i in 1 until N) {
            val (fe, r) = q.remove()

            if (B[i].s >= fe)
                q.add(EndAndRoom(B[i].e, r))
            else {
                q.add(EndAndRoom(fe, r))
                rNum++
                q.add(EndAndRoom(B[i].e, rNum))
            }
        }
        print(rNum)
    }
}

fun main() { `22867`().solution() }