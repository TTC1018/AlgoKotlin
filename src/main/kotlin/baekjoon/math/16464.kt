package baekjoon.math

import kotlin.math.pow

class `16464` {
    fun solution() = with(System.`in`.bufferedReader()) {
        var T = readLine().toInt()
        val sb = StringBuilder()
        loop@ while (T-- > 0) {
            val K = readLine().toInt()
            for (n in 1 until 30) {
                if (K == (2.0).pow(n).toInt()) {
                    sb.appendLine("GoHanGang")
                    continue@loop
                }
            }
            sb.appendLine("Gazua")
        }
        print(sb.dropLast(1))
    }
}