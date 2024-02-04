package baekjoon.sorting

import java.util.StringTokenizer

class `16112` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, k) = readLine().split(" ").map(String::toInt)
        val a = LongArray(n).apply {
            val st = StringTokenizer(readLine())
            for (i in 0 until n) {
                this[i] = st.nextToken().toLong()
            }
        }

        a.sort()
        var answer = 0L
        for (i in 0 until k) {
            answer += a[i] * i
        }
        for (i in k until n) {
            answer += a[i] * k
        }
        print(answer)
    }

}