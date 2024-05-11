package baekjoon.implementation

class `22858` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val S = readLine().split(' ').map(String::toInt).toIntArray()
        val D = readLine().split(" ").map(String::toInt)
        val prev = IntArray(N)
        repeat(K) {
            for (i in S.indices) {
                prev[D[i] - 1] = S[i]
            }
            prev.copyInto(S)
        }
        print(S.joinToString(" "))
    }
}