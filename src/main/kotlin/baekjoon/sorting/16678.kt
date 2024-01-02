package baekjoon.sorting

class `16678` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        var answer = 0L
        val A = List(N) { readLine().toInt() }.toIntArray().sortedArray().apply {
            answer += first() - 1
            this[0] = 1
        }
        for (i in 1 until N) {
            takeIf { A[i] > A[i-1] }
                ?.let {
                    answer += A[i] - (A[i-1] + 1)
                    A[i] = A[i-1] + 1
                }
        }
        print(answer)
    }
}