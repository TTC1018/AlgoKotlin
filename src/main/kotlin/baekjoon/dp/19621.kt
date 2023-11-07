package baekjoon.dp

class `19621` {
    private data class Room(
        val s: Long,
        val e: Long,
        val c: Long,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val R = List(N) { readLine().split(" ").map(String::toLong).run { Room(first(), this[1], last()) } }
        val dp = LongArray(N).apply {
            this[0] = R.first().c
            if (N > 1)
                this[1] = R[1].c
            if (N > 2)
                this[2] = this[0] + R[2].c
        }

        for (i in 3 until N) {
            dp[i] = maxOf(dp[i-2], dp[i-3]) + R[i].c
        }
        print(dp.maxOf { it })
    }
}