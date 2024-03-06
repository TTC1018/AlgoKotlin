package baekjoon.hashset

import java.util.StringTokenizer

class `13701` {
    fun main() = with(System.`in`.bufferedReader()) {
        val st = StringTokenizer(readLine())
        val s = mutableSetOf<Int>()
        val sb = StringBuilder()
        while (st.hasMoreTokens()) {
            val a = st.nextToken().toInt()

            if (a !in s) {
                s.add(a)
                sb.append(a).append(" ")
            }
        }
        print(sb.dropLast(1))
    }
}