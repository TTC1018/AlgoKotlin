package baekjoon.dp

class `25634` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val a = readLine().split(" ").map(String::toInt)
        val b = readLine().split(" ").map(String::toInt)
        val total = a.filterIndexed { i, _ -> b[i] == 1 }.sumOf { it }
        // 딱 한번 1개 이상 연속된 전구를 뒤집음
        var answer: Int
        val dp = IntArray(N).apply {
            this[0] = if (b[0] == 0) a[0] else -a[0]
            answer = this[0]
        }

        // 지금 뒤집는다는 가정하에 전구가 켜져있다면 총 값에서 차감되는 것
        // 이전까지의 뒤집었을 때 최대값이 양수라면 이어서 뒤집으면 됨
        for (i in 1 until N) {
            dp[i] = if (b[i] == 0) a[i] else -a[i]
            if (dp[i - 1] > 0)
                dp[i] += dp[i - 1]
            answer = maxOf(answer, dp[i])
        }
        print(answer + total)
    }
}