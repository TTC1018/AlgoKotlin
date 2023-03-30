package baekjoon.priorityqueue

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

class `2461` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val students = Array(N) { r -> readLine().split(" ").map { IndexedValue(r, it.toInt()) }.sortedBy { it.value } }
        val idxes = IntArray(N)
        var maxVal = 0
        val pq = PriorityQueue<IndexedValue<Int>> { o1, o2 -> o1.value.compareTo(o2.value) }
            .also {
                it.addAll(students.map { s ->
                    val f = s.first()
                    maxVal = max(maxVal, f.value)
                    f
                })
            }

        var minVal = 1e9.toInt()+1
        while (pq.isNotEmpty()){
            val (idx, num) = pq.remove()
            minVal = min(minVal, maxVal - num)
            idxes[idx]++
            if (idxes[idx] == M)
                break

            val nxt = students[idx][idxes[idx]]
            maxVal = max(maxVal, nxt.value)
            pq.add(nxt)
        }
        print(minVal)
    }

}

fun main() {

    `2461`().solution()

}