package baekjoon.greedy

class `2140` {
    private data class Step(
        val x: Int,
        val y: Int,
    )

    private val d = listOf(
        Step(-1, -1), Step(-1, 0), Step(-1, 1),
        Step(0, -1), Step(0, 1),
        Step(1, -1), Step(1, 0), Step(1, 1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val B = List(N) { readLine().toCharArray() }
        // 테두리에 못 닿는 영역은 무조건 지뢰가 있다고 생각 -> 최대
        val V = mutableSetOf<Step>()
        val firstLast = listOf(1, N - 2)
        var answer = 0
        val inRange: (Int, Int) -> Boolean = { a, b -> a == 0 || a == N - 1 || b == 0 || b == N - 1 }

        for (i in 1..N - 2) {
            firstLast.forEach { j ->
                listOf(Step(i, j), Step(j, i)).forEach { now ->
                    if (now !in V) {
                        V.add(now)
                        val count = d.count { (dx, dy) ->
                            val (nx, ny) = now.x + dx to now.y + dy
                            inRange(nx, ny) && B[nx][ny].run { isDigit() && this > '0' }
                        }

                        if (i in firstLast && j in firstLast) {
                            if (count >= 5) {
                                d.forEach { (dx, dy) ->
                                    val (nx, ny) = now.x + dx to now.y + dy
                                    if (inRange(nx, ny) && B[nx][ny].isDigit()) {
                                        B[nx][ny]--
                                    }
                                }
                                answer++
                            }
                        } else if (count == 3) {
                            d.forEach { (dx, dy) ->
                                val (nx, ny) = now.x + dx to now.y + dy
                                if (inRange(nx, ny) && B[nx][ny].isDigit()) {
                                    B[nx][ny]--
                                }
                            }
                            answer++
                        }
                    }
                }
            }
        }
        print(answer + (N - 4).coerceAtLeast(0).let { it * it })
    }
}