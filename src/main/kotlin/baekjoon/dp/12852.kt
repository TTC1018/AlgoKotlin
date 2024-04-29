package baekjoon.dp

class `12852` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val X = readLine().toInt()
        val dp = IntArray(X + 1) { Int.MAX_VALUE }.apply {
            this[1] = 0
            if (X >= 2)
                this[2] = 1
            if (X >= 3)
                this[3] = 1
            for (n in 4..X) {
                this[n] = minOf(this[n], this[n - 1] + 1)
                if (n % 2 == 0)
                    this[n] = minOf(this[n], this[n / 2] + 1)
                if (n % 3 == 0)
                    this[n] = minOf(this[n], this[n / 3] + 1)
            }
        }
        println(dp.last())

        var now = X
        val answer = StringBuilder()
        while (now > 1) {
            answer.append("$now ")
            when {
                dp[now - 1] == dp[now] - 1 -> now--
                now % 2 == 0 && dp[now / 2] == dp[now] - 1 -> now /= 2
                now % 3 == 0 && dp[now / 3] == dp[now] - 1 -> now /= 3
            }
        }
        answer.append(1)
        print(answer)
    }
}