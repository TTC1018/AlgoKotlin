package baekjoon.dp

class `19622` {
    private data class Conf(
        val s: Int,
        val e: Int,
        val n: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val C = List(N) { readLine().split(" ").map(String::toInt).run { Conf(first(), this[1], last()) } }
        // 회의 K는 K-1, K+1이랑만 겹친다.
        // 즉 K를 고르려면 K-2+K vs. K-1을 할 수 밖에 없다.
        // dp?
        val dp = IntArray(N).apply {
            this[0] = C.first().n
            if (N > 1)
                this[1] = maxOf(this[0], C[1].n)
        }
        for (i in 2 until N) {
            dp[i] = maxOf(dp[i-1], dp[i-2]+C[i].n)
        }
        print(dp.last())
    }
}