package baekjoon.prefixsum

class `27496` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, L) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toInt)
        val P = IntArray(N).apply {
            for (i in 0 until N) {
                this[i] += A[i]
                (i + L).takeIf { it < N }
                    ?.let { this[it] -= A[i] }
            }

            for (i in 1 until N) {
                this[i] += this[i - 1]
            }
        }

        var answer = 0
        var cnt = 0
        for (i in 0 until N) {
            if (P[i] in 129..138) {
                cnt++
            } else {
                answer += cnt
                cnt = 0
            }
        }
        print(answer + cnt)
    }
}