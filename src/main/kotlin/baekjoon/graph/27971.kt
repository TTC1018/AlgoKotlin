package baekjoon.graph

class `27971` {
    private data class Step(
        val now: Int,
        val cnt: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M, A, B) = readLine().split(" ").map(String::toInt)
        val R = IntArray(N + 1) { Int.MAX_VALUE }.apply { this[0] = 0 }
        repeat(M) {
            val (Li, Ri) = readLine().split(" ").map(String::toInt)
            (Li..Ri).forEach { R[it] = -1 }
        }
        val q = ArrayDeque<Step>().apply { add(Step(0, 0)) }
        while (q.isNotEmpty()) {
            val (now, cnt) = q.removeFirst()
            if (now == N) {
                print(cnt)
                return@with
            }

            if (now + A <= N && cnt + 1 < R[now + A]) {
                R[now + A] = cnt + 1
                q.add(Step(now + A, cnt + 1))
            }
            if (now + B <= N && cnt + 1 < R[now + B]) {
                R[now + B] = cnt + 1
                q.add(Step(now + B, cnt + 1))
            }
        }
        print(-1)
    }
}