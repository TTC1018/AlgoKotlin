package baekjoon.greedy

class `31673` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val V = readLine().split(" ").map(String::toLong).sorted()
        val total = V.sumOf { it }
        var sumVal = total
        for (i in V.indices.reversed()) {
            sumVal -= V[i]
            if (sumVal <= total / 2) {
                print(M / (N - i + 1))
                break
            }
        }
    }
}