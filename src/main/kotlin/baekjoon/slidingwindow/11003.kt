package baekjoon.slidingwindow

import java.util.StringTokenizer


fun main() {

    data class NumAndIdx(
        val num: Int,
        val idx: Int
    ):Comparable<NumAndIdx> {
        override fun compareTo(other: NumAndIdx) = num.compareTo(other.num)
    }

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val L = st.nextToken().toInt()

    val A = StringTokenizer(br.readLine())
    val q = ArrayDeque<NumAndIdx>()
    for (i in 0 until N) {
        val aI = A.nextToken().toInt()

        if (q.isNotEmpty() && q.first().idx < i - L + 1)
            q.removeFirst()

        while (q.isNotEmpty() && q.last().num > aI)
            q.removeLast()

        q.add(NumAndIdx(aI, i))
        bw.write("${q.first().num} ") // 남아있는 수들 중 최솟값
    }
    bw.flush()

}