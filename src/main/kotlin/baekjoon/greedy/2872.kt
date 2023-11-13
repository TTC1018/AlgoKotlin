package baekjoon.greedy

class `2872` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = List(N) { readLine().toInt() }
        var maxIdx = B.withIndex().maxBy { it.value }.index
        var answer = N-1 - maxIdx

        for (i in maxIdx-1 downTo 0) {
            if (B[i] == B[maxIdx] - 1) {
                maxIdx = i
            } else {
                answer++
            }
        }
        print(answer)
    }
}