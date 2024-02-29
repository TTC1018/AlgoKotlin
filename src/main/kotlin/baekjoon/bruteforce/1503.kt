package baekjoon.bruteforce

import kotlin.math.absoluteValue

class `1503` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val S = BooleanArray(1000 + 2) { false }.apply {
            if (M > 0) {
                readLine().split(" ").map(String::toInt).forEach { this[it] = true }
            }
        }

        var answer = Int.MAX_VALUE
        for (i in 1..1000) {
            if (S[i])
                continue
            for (j in i..1000) {
                if (S[j])
                    continue
                for (k in j..1001) {
                    if (S[k])
                        continue

                    val v = (N - i * j * k).absoluteValue
                    answer = minOf(v, answer)
                }
            }
        }
        print(answer)
    }
}