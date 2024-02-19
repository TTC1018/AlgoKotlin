package baekjoon.twopointer

class `28353` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toLong)
        val w = readLine().split(" ").map(String::toLong).sorted()

        var (l, r) = 0 to (N - 1).toInt()
        var answer = 0
        while (l < r) {
            val sumVal = w[l] + w[r]

            when {
                sumVal > K -> { r-- }
                sumVal <= K -> { l++; r--; answer++ }
            }
        }
        print(answer)
    }
}