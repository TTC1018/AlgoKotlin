package baekjoon.dp

class `11985` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, K) = readLine().split(" ").map(String::toInt)
        val A = listOf(0L) + List(N) { readLine().toLong() }
        // 포장 비용: K + s * (a-b) -> K는 고정
        // 포장 비용의 최솟값 구하기
        // 한개 더 만드냐 vs 연장해도 더 값이 적냐
        val dp = LongArray(N + 1) { K.toLong() * it }
        for (n in 0 until N) {
            var minVal = A[n + 1]
            var maxVal = A[n + 1]

            // Bottom-up으로 상위 값들 갱신
            var cnt = 1
            while (n + cnt <= N && cnt <= M) {
                minVal = minOf(minVal, A[n + cnt])
                maxVal = maxOf(maxVal, A[n + cnt])
                dp[n + cnt] = minOf(
                    dp[n + cnt],
                    dp[n] + K + cnt * (maxVal - minVal)
                )
                cnt++
            }
        }
        print(dp.last())
    }
}