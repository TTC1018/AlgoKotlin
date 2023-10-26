package baekjoon.shortestpath

import java.util.*
import kotlin.math.absoluteValue

class `12908` {
    private data class Step(
        val x: Long,
        val y: Long,
        val cnt: Long = 0,
    ) : Comparable<Step> {
        override fun compareTo(other: Step): Int {
            return cnt.compareTo(other.cnt)
        }
    }

    private val T = mutableMapOf<Step, Step>()

    fun solution() = with(System.`in`.bufferedReader()) {
        val (xs, ys) = readLine().split(" ").map(String::toLong)
        val (xe, ye) = readLine().split(" ").map(String::toLong)
        val locs = mutableListOf<Step>().apply {
            add(Step(xs, ys))
            add(Step(xe, ye))
        }
        for (i in 0 until 3) {
            val (x1, y1, x2, y2) = readLine().split(" ").map(String::toLong)
            if ((x1 - x2).absoluteValue + (y1 - y2).absoluteValue <= 10)
                continue

            val a = Step(x1, y1)
            val b = Step(x2, y2)
            T[a] = b
            T[b] = a
            locs.add(a)
            locs.add(b)
        }

        // 출발 -> 도착 최대시간은 한칸씩 가는 것
        // 가능한 케이스
        // 텔레포트가 효율적이려면 -> 입구-출구 간의 거리가 10 이하여야 됨
        // 아닌 것은 쳐내기
        val dist = LongArray(2 + T.size) { Long.MAX_VALUE }.apply {
            this[0] = 0
            this[size - 1] = (xs - xe).absoluteValue + (ys - ye).absoluteValue
        }

        val pq = PriorityQueue<Step>().apply {
            add(Step(xs, ys))
        }

        while (pq.isNotEmpty()) {
            val (x, y, cnt) = pq.remove()
            if (x == xe && y == ye) {
                break
            }

            for (i in locs.indices) {
                val (nx, ny) = locs[i]
                if (x == nx && y == ny)
                    continue

                if (T.getOrDefault(Step(x, y), Step(-1, -1)) == locs[i]) {
                    if (cnt + 10 < dist[i]) {
                        dist[i] = cnt + 10
                        pq.add(Step(nx, ny, cnt + 10))
                    }
                }

                val cost = (x - nx).absoluteValue + (y - ny).absoluteValue
                if (cnt + cost < dist[i]) {
                    dist[i] = cnt + cost
                    pq.add(Step(nx, ny, cnt + cost))
                }
            }
        }

        print(dist[1])
    }
}