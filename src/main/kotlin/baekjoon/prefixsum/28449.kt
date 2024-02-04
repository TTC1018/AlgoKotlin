package baekjoon.prefixsum

class `28449` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val a = readLine().split(" ").map(String::toInt).sorted()
        val b = readLine().split(" ").map(String::toInt).sorted()

        val P = LongArray(100000 + 2).apply {
            for (arc in b) {
                this[arc]++
            }
            for (i in 1..100000) {
                this[i] += this[i-1]
            }
        }

        val answer = LongArray(3)
        for (hi in a) {
            answer[0] += P[hi-1]
            answer[1] += P[100000] - P[hi]
            answer[2] += P[hi] - P[hi-1]
        }
        print(answer.joinToString(" "))
    }
}