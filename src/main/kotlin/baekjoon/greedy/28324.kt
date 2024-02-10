package baekjoon.greedy

class `28324` {
    fun main() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val V = readLine().split(" ").map(String::toLong)
        // minOf(지금 속력제한 + 1, 이전 속력제한)
        var answer = 0L
        var maxVal = 1L
        for (i in N - 1 downTo 1) {
            answer += maxVal
            maxVal = minOf(maxVal + 1, V[i - 1])
        }
        print(answer + maxVal)
    }
}