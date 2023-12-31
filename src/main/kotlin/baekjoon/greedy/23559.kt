package baekjoon.greedy

import java.util.*

class `23559` {
    private data class DiffInfo(
        val diff: Int,
        val a: Int,
    ): Comparable<DiffInfo> {
        override fun compareTo(other: DiffInfo): Int {
            return other.diff.compareTo(diff)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        var N: Int
        var X: Int
        readLine().split(" ").map(String::toInt).run {
            N = first(); X = last()
        }
        val pq = PriorityQueue<DiffInfo>().apply {
            repeat(N) {
                add(readLine().split(" ").map(String::toInt).run { DiffInfo(first() - last(), first()) })
            }
        }

        // 맛의 합을 최대화 시키는 법
        // 최대한 차이가 많이 나는 날짜에 5000원짜리를 먹는다
        var answer = 0L
        for (cnt in 1..N) {
            if (X >= 5000*cnt + 1000*(N-cnt)) {
                if (pq.first().diff > 0) {
                    answer += pq.remove().a
                } else { // B가 더 나은데 굳이 A를 먹을 필요 없음
                    break
                }
            } else {
                break
            }
        }

        while (pq.isNotEmpty()) {
            val info = pq.remove()
            answer += (info.a - info.diff)
        }
        print(answer)
    }
}