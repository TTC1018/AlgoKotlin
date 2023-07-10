package baekjoon.graph

class `2412` {
    private data class Grip(
        val x: Int,
        val y: Int,
        val cnt: Int = 0
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (n, T) = readLine().split(" ").map(String::toInt)
        val G = Array(n) { readLine().split(" ").map(String::toInt).let { Grip(it[0], it[1]) } }.toSet()

        val q = ArrayDeque<Grip>().apply { add(Grip(0, 0)) }
        val visited = mutableSetOf<Grip>().apply { add(Grip(0, 0)) }
        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (y == T) {
                print(cnt)
                return
            }

            for (i in maxOf(0, x - 2)..x + 2) {
                for (j in maxOf(0, y - 2)..y + 2) {
                    val cand = Grip(i, j)
                    if (cand in G && cand !in visited) {
                        visited.add(cand)
                        q.add(Grip(i, j, cnt + 1))
                    }
                }
            }
        }

        print(-1)
    }
}

fun main() {
    `2412`().solution()
}