package baekjoon.graph

import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

class `1325` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val next = List(N) { mutableListOf<Int>() }.apply {
            for (i in 0 until M) {
                val st = StringTokenizer(readLine())
                this[st.nextToken().toInt() - 1].add(st.nextToken().toInt() - 1)
            }
        }

        val q = ArrayDeque<Int>()
        val answer = IntArray(N)
        val V = BooleanArray(N) { false }
        for (i in 0 until N) {
            V.fill(false)
            V[i] = true
            q.add(i)
            while (q.isNotEmpty()) {
                val now = q.removeFirst()

                for (nxt in next[now]) {
                    if (V[nxt].not()) {
                        answer[nxt]++
                        V[nxt] = true
                        q.add(nxt)
                    }
                }
            }
        }

        val maxVal = answer.maxOf { it }
        val sb = StringBuilder()
        for (i in 0 until N) {
            if (answer[i] == maxVal) {
                sb.append("${i + 1} ")
            }
        }
        print(sb.dropLast(1))
    }
}