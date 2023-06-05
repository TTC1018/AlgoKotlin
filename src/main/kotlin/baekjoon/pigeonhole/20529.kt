package baekjoon.pigeonhole

import kotlin.math.min

class `20529` {

    fun solution() = with(System.`in`.bufferedReader()) {

        repeat(readLine().toInt()) {

            val N = readLine().toInt()
            val mbti = readLine().split(" ")
            if (N > 32) {
                println(0)
            }
            else {
                var answer = Int.MAX_VALUE
                for (i in 0 until N) {
                    for (j in 0 until N) {
                        for (k in 0 until N) {
                            if (i == j || j == k || i == k)
                                continue

                            var tmp = 0
                            tmp += mbti[i].zip(mbti[j]).count { it.first != it.second }
                            tmp += mbti[j].zip(mbti[k]).count { it.first != it.second }
                            tmp += mbti[i].zip(mbti[k]).count { it.first != it.second }
                            answer = min(answer, tmp)
                        }
                    }
                }
                println(answer)
            }
        }
    }

}

fun main() {

    `20529`().solution()

}