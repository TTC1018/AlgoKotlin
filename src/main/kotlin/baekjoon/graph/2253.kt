package baekjoon.graph

class `2253` {
    private data class Jump(
        val now: Int,
        val speed: Int = 1,
        val cnt: Int = 1,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val S = BooleanArray(N) { true }.apply {
            repeat(M) {
                this[readLine().toInt() - 1] = false
            }
        }
        val V = List(N) { mutableSetOf<Int>() }.apply {
            if (S[1]) {
                this[1].add(1)
            }
        }
        val q = ArrayDeque<Jump>().apply {
            if (S[1]) {
                add(Jump(1))
            }
        }

        while (q.isNotEmpty()) {
            val (now, speed, cnt) = q.removeFirst()
            if (now == N - 1) {
                print(cnt)
                return
            }

            val fastest = now + speed + 1
            val normal = now + speed
            val slowest = now + speed - 1

            if (fastest < N && S[fastest] && (speed + 1) !in V[fastest]) {
                V[fastest].add(speed + 1)
                q.add(Jump(fastest, speed + 1, cnt + 1))
            }
            if (normal < N && S[normal] && speed !in V[normal]) {
                V[normal].add(speed)
                q.add(Jump(normal, speed, cnt + 1))
            }
            if (speed > 1 && slowest < N && (speed - 1) !in V[slowest]) {
                V[slowest].add(speed - 1)
                q.add(Jump(slowest, speed - 1, cnt + 1))
            }
        }
        print(-1)
    }
}