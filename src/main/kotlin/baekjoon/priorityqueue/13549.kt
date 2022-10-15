package baekjoon.priorityqueue

import java.util.PriorityQueue

class `13549` {

    data class PosData(
        val now:Int,
        val count:Int
    ):Comparable<PosData> {
        override fun compareTo(other: PosData) =
            this.count - other.count
    }

    fun solution() = with(System.`in`.bufferedReader()){
        val (N, K) = readLine().split(" ").map { it.toInt() }
        val visited = Array(100000 + 1) { false }
        val pq = PriorityQueue<PosData>().apply {
            add(PosData(N, 0))
        }

        while (pq.isNotEmpty()){
            val (now, count) = pq.poll()
            if (now == K){
                println(count)
                break
            }

            visited[now] = true

            if (now * 2 <= 100000 && visited[now * 2].not()){
                pq.add(PosData(now * 2, count))
            }
            if (now > 0 && visited[now - 1].not()) {
                pq.add(PosData(now - 1, count + 1))
            }
            if (now < 100000 && visited[now + 1].not()){
                pq.add(PosData(now + 1, count + 1))
            }
        }

    }

}

fun main(){

    `13549`().solution()

}