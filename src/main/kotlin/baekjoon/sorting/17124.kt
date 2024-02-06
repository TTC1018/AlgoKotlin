package baekjoon.sorting

import kotlin.math.absoluteValue

class `17124` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val sb = StringBuilder()
        repeat(readLine().toInt()) {
            val (n, m) = readLine().split(" ").map(String::toInt)
            val A = readLine().split(" ").map(String::toLong).sorted()
            val B = readLine().split(" ").map(String::toLong).sorted()

            var answer = 0L
            var ptr = 0
            for (a in A) {
                while (ptr < m && B[ptr] <= a) {
                    ptr++
                }

                answer += if (ptr == m) {
                    B.last()
                } else if (ptr - 1 >= 0) {
                    if ((a - B[ptr]).absoluteValue >= (a - B[ptr - 1]).absoluteValue) {
                        B[ptr - 1]
                    } else {
                        B[ptr]
                    }
                } else {
                    B[ptr]
                }
            }
            sb.appendLine(answer)
        }
        print(sb.dropLast(1))
    }
}