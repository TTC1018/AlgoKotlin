package baekjoon.hashset

class `17092` {
    private data class Loc(
        val x: Int,
        val y: Int
    )

    private lateinit var B: Set<Loc>
    private val answer = LongArray(9 + 1)
    private val visited = mutableSetOf<Loc>()
    private val d = listOf(
        Loc(-1, -1), Loc(-1, 0), Loc(-1, 1),
        Loc(0, -1), Loc(0, 0), Loc(0, 1),
        Loc(1, -1), Loc(1, 0), Loc(1, 1)
    )

    private fun countArea(loc: Loc) {
        val (x, y) = loc
        answer[d.count { (dx, dy) -> Loc(x + dx, y + dy) in B }]++
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (H, W, N) = readLine().split(" ").map(String::toInt)
        B = buildSet {
            repeat(N) {
                add(readLine().split(" ").map { it.toInt() - 1 }.run { Loc(first(), last()) })
            }
        }
        val inRange: (Loc) -> Boolean = { (x, y) -> x in 1..H - 2 && y in 1..W - 2 }

        for ((bx, by) in B) {
            for ((dx, dy) in d) {
                val loc = Loc(bx + dx, by + dy)
                if (inRange(loc) && loc !in visited) {
                    visited.add(loc)
                    countArea(loc)
                }
            }
        }

        answer[0] += ((H.toLong() - 2) * (W.toLong() - 2) - answer.sumOf { it })
        print(answer.joinToString("\n"))
    }
}

fun main() {
    `17092`().solution()
}