package baekjoon.graph

class `14550` {
    private data class Loc(
        val x: Int,
        val coin: Int,
        val turn: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        while (true) {
            val line = readLine()
            if (line.first() == '0')
                return

            val (N, S, T) = line.split(" ").map(String::toInt)
            val B = mutableListOf<Int>().apply {
                add(-1)
                while (this.size < N+1) {
                    addAll(readLine().split(" ").map(String::toInt))
                }
            }
            val visited = IntArray(N + 1) { -10000*200 }.apply {
                this[0] = 0
            }
            val q = ArrayDeque<Loc>().apply {
                add(Loc(0, 0, 0))
            }

            var answer = -Int.MIN_VALUE
            loop@while (q.isNotEmpty()) {
                val (now, coin, turn) = q.removeFirst()

                for (s in 1..S) {
                    val next = (now + s).coerceAtMost(N+1)
                    if (next == N + 1) {
                        if (turn + 1 <= T)
                            answer = maxOf(answer, coin)
                        continue@loop
                    }

                    val nextCoin = coin + B[next]
                    if (nextCoin > visited[next] && turn + 1 <= T) {
                        visited[next] = nextCoin
                        q.add(Loc(next, nextCoin, turn + 1))
                    }
                }
            }
            println(answer)
        }
    }
}