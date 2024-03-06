package baekjoon.bitmasking

import java.util.BitSet
import java.util.StringTokenizer

class `13701` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val st = StringTokenizer(readLine())
        val s = BitSet()
        val sb = StringBuilder()
        while (st.hasMoreTokens()) {
            val a = st.nextToken().toInt()

            if (s[a].not()) {
                s.set(a)
                sb.append(a).append(" ")
            }
        }
        print(sb.dropLast(1))
    }
}