package baekjoon.greedy

class `15553` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val T = List(N) { readLine().toInt() }
            .zipWithNext()
            .map { (p, n) -> n - p }
            .sorted()

        print(T.slice(0 until N-K).sumOf { it } + K)
    }
}