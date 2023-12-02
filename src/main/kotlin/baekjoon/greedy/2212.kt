package baekjoon.greedy

class `2212` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val K = readLine().toInt()
        val S = readLine().split(" ").map(String::toInt).sorted()
            .zipWithNext()
            .map { (p, n) -> n - p }
            .sorted()

        // 긴 곳 제외하고 남은 곳을 커버할 길이
        print(S.slice(0 until N - K).sumOf { it })
    }
}