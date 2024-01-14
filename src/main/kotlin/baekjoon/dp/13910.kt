package baekjoon.dp

class `13910` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val S = readLine().split(" ").map(String::toInt)
        // 웍은 2개까지 동시에 사용 가능
        // 정확히 필요한 만큼만 만들어야 함
        // 한번에 만들 수 있는 양부터 구하기
        val comb = buildSet {
            for (i in 0 until M) {
                add(S[i])
                for (j in i + 1 until M) {
                    add(S[i] + S[j])
                }
            }
        }.sorted()

        val dp = IntArray(N + 1) { 10001 }.apply {
            this[0] = 0
        }

        for (n in 1..N) {
            for (c in comb) {
                if (c > n)
                    break
                dp[n] = minOf(dp[n], dp[n - c] + 1)
            }
        }

        if (dp.last() >= 10001)
            print(-1)
        else
            print(dp.last())
    }
}