package baekjoon.dp

class `29704` {
    private data class Prob(
        val d: Int,
        val m: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, T) = readLine().split(" ").map(String::toInt)
        val P = List(N) { readLine().split(" ").map(String::toInt).run { Prob(first(), last()) } }
        // 벌금 큰 것 부터 해결 -> 3 2, 2-5000 1-3000 1-4000 일 때 손해
        // 날짜 작고 벌금 큰 것 부터 해결 -> 3 2, 2-5000 1-1000 1-2000 일 때 손해
        // 경우의 수를 따져봐야 됨
        val dp = IntArray(T + 1)
        for (i in 0 until N) {
            // 거꾸로 탐색으로 중복 제거
            for (t in T downTo P[i].d) {
                dp[t] = maxOf(dp[t], dp[t - P[i].d] + P[i].m)
            }
        }
        print(P.sumOf { it.m } - dp.last())
    }
}