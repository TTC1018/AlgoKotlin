package baekjoon.graph

class `13913` {
    private data class Loc(
        val x: Int,
        val cnt: Int = 0
    )

    private val MAX_VAL = 1e5.toInt()

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val q = ArrayDeque<Loc>().apply {
            add(Loc(N, 0))
        }
        val visited = IntArray(MAX_VAL + 1) { Int.MAX_VALUE }.apply { this[N] = 0 }
        val step = listOf<(Int) -> Int>({ x -> x - 1 }, { x -> x + 1 }, { x -> x * 2 })
        while (q.isNotEmpty()) {
            val (now, cnt) = q.removeFirst()
            if (now == K) {
                println(cnt)
                print(
                    buildList {
                        var tenet = K
                        add(tenet)
                        while (tenet != N) {
                            when {
                                tenet % 2 == 0 && visited[tenet / 2] + 1 == visited[tenet] -> tenet /= 2
                                tenet - 1 >= 0 && visited[tenet - 1] + 1 == visited[tenet] -> tenet--
                                tenet + 1 <= MAX_VAL && visited[tenet + 1] + 1 == visited[tenet] -> tenet++
                            }
                            add(tenet)
                        }
                    }.reversed().joinToString(" ")
                )
                return
            }

            step.forEach {
                it(now).takeIf { next -> next in 0..MAX_VAL }
                    ?.also { next ->
                        if (cnt + 1 < visited[next]) {
                            visited[next] = cnt + 1
                            q.add(Loc(next, cnt + 1))
                        }
                    }
            }
        }
    }
}

fun main() {
    `13913`().solution()
}