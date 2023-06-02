package baekjoon.geometry

import kotlin.math.absoluteValue
import kotlin.math.pow


class `17371` {

    data class Loc(
        val x: Long,
        val y: Long
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val H = Array(N) { readLine().split(" ").map { it.toLong() }.let { Loc(it.first(), it.last()) } }

        var answer = -1
        var minVal = Long.MAX_VALUE
        for (i in 0 until N) {
            var maxVal = -1L
            var tmpIdx = -1
            for (j in 0 until N) {
                val xDiff = (H[i].x - H[j].x)*(H[i].x - H[j].x)
                val yDiff = (H[i].y - H[j].y)*(H[i].y - H[j].y)

                val dist = xDiff + yDiff
                if (maxVal < dist){
                    maxVal = dist
                    tmpIdx = i
                }
            }

            if (maxVal != -1L && maxVal < minVal) {
                minVal = maxVal
                answer = tmpIdx
            }
        }

        print("${H[answer].x} ${H[answer].y}")
    }

}

fun main() {

    `17371`().solution()

}