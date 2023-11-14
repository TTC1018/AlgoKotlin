package baekjoon.graph

class `16568` {
    private data class LocAndTime(
        val x: Int,
        val t: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, a, b) = readLine().split(" ").map(String::toInt)
        val q = ArrayDeque<LocAndTime>().apply {
            add(LocAndTime(0, 0))
        }

        val visited = IntArray(N + 1) { it }
        while (q.isNotEmpty()) {
            val (now, t) = q.removeFirst()
            if (now + 1 <= N && t + 1 < visited[now + 1]) {
                visited[now + 1] = t + 1
                q.add(LocAndTime(now + 1, t + 1))
            }
            if (now + 1 + a <= N && t + 1 < visited[now + 1 + a]) {
                visited[now + 1 + a] = t + 1
                q.add(LocAndTime(now + 1 + a, t + 1))
            }
            if (now + 1 + b <= N && t + 1 < visited[now + 1 + b]) {
                visited[now + 1 + b] = t + 1
                q.add(LocAndTime(now + 1 + b, t + 1))
            }
        }
        print(visited[N])
    }
}