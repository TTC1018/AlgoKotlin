package baekjoon.dp

class `2302` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val M = readLine().toInt()
        val fixed = IntArray(M) { readLine().toInt() }
        val dp = IntArray(N + 1) { 0 } // x개 있을 때 만들 수 있는 경우의 수

        dp[0] = 1; dp[1] = 1
        (2 ..N).forEach {
            dp[it] = dp[it - 1] + dp[it - 2]
        }

        var answer = 1
        var prev = 0

        // 각 고정좌석 사이에 있는 경우의 수들의 곱
        for (fix in fixed) {
            answer *= dp[fix - prev - 1]
            prev = fix
        }
        answer *= dp[N - prev] // 마지막 고정좌석 우측의 경우의 수

        print(answer)
    }

}

fun main() {

    `2302`().solution()

}