package baekjoon.geometry

import kotlin.math.min

class `17843` {

    fun solution() = with(System.`in`.bufferedReader()) {

        repeat(readLine().toInt()) {
            val hms = readLine().split(" ").map(String::toDouble).toDoubleArray()
                .also {
                    it[0] *= 5.0 // 시침 60 기준으로 변경
                }
            hms[1] += (hms[2] / 60) // 시침 위치에 따른 분침 위치
            hms[0] += (hms[1] * 5 / 60) // 분침 위치에 따른 시침 위치
            hms.sort()

            var answer = 360.0
            for (i in 0..1) {
                val d = (hms[i + 1] - hms[i]) * 6 // 360도 변환
                answer = min(answer, d)
            }
            answer = min(answer, (hms.first() + (60 - hms.last())) * 6)
            println(answer)
        }

    }

}

fun main() {

    `17843`().solution()

}