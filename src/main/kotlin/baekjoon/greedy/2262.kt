package baekjoon.greedy

class `2262` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val A = readLine().split(" ").map(String::toInt)
        var answer = 0
        val maxIdx = A.withIndex().sortedByDescending { it.value }
        val V = BooleanArray(n) { false }
        var iPtr = 0
        for (i in 0 until n - 1) {
            val (tIdx, tVal) = maxIdx[iPtr]
            V[tIdx] = true

            var j = tIdx - 1
            val left = A.subList(0, tIdx).findLast { V[j--].not() } ?: -1

            j = tIdx + 1
            val right = A.subList(tIdx + 1, n).find { V[j++].not() } ?: -1

            answer += tVal - maxOf(left, right)
            iPtr++
        }
        print(answer)
    }
}