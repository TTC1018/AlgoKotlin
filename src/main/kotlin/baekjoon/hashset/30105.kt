package baekjoon.hashset

import kotlin.math.absoluteValue

class `30105` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val x = readLine().split(" ").map(String::toInt)

        var K = mutableSetOf<Int>().apply {
            for (i in 1 until N) {
                add(x[i] - x.first())
            }
        }

        // x[i]를 기준으로 하는 모든 거리를 탐색
        for (i in 1 until N) {
            val tempK = mutableSetOf<Int>()
            // 이빨 자국이 될 수 있는 위치라면 끝까지 살아남음
            for (j in 0 until N) {
                if (j != i) {
                    val d = (x[i] - x[j]).absoluteValue
                    if (d in K) {
                        tempK.add(d)
                    }
                }
            }

            if (tempK.isEmpty()) {
                K.clear()
                break
            }
            K = tempK
        }

        println(K.size)
        if (K.size > 0)
            print(K.toSortedSet().joinToString(" "))
    }
}