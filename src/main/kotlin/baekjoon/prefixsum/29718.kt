package baekjoon.prefixsum

class `29718` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(' ').map(String::toInt)
        val B = IntArray(M).apply {
            repeat(N) {
                readLine().split(" ").map(String::toInt).forEachIndexed { i, v ->
                    this[i] += v
                }
            }
        }
        val A = readLine().toInt()
        val P = IntArray(M).apply {
            this[0] = B.first()
            for (i in 1 until M) {
                this[i] += (this[i - 1] + B[i])
            }
        }

        var answer = P[A - 1]
        for (i in A until M) {
            answer = maxOf(answer, P[i] - P[i - A])
        }
        print(answer)
    }
}