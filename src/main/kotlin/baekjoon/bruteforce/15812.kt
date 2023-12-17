package baekjoon.bruteforce

class `15812` {
    private var N = 0
    private var M = 0
    private lateinit var B: List<List<Int>>
    private val locs = mutableListOf<Int>()
    private var answer = Int.MAX_VALUE
    private var V = 0
    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private fun check(): Int {
        val visited = List(N) { BooleanArray(M) { false } }
        var cnt = 0
        var q = mutableListOf<Loc>().apply {
            locs.forEach { l ->
                val (x, y) = l.div(M) to l.mod(M)
                add(Loc(x, y))
                visited[x][y] = true
            }
        }

        var sec = 0
        while (cnt < V) {
            val next = mutableListOf<Loc>()
            for ((x, y) in q) {
                for ((dx, dy) in d) {
                    val (nx, ny) = x + dx to y + dy
                    if (nx in 0 until N && ny in 0 until M) {
                        if (visited[nx][ny].not()) {
                            visited[nx][ny] = true
                            next.add(Loc(nx, ny))
                            if (B[nx][ny] == 1)
                                cnt++
                        }
                    }
                }
            }
            q = next
            sec++
        }
        return sec
    }

    private fun bruteforce(idx: Int, cnt: Int) {
        if (cnt == 2) {
            answer = minOf(answer, check())
            return
        }

        for (i in idx until N*M) {
            if (B[i/M][i%M] == 0) {
                locs.add(i)
                bruteforce(i, cnt + 1)
                locs.removeLast()
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        B = List(N) { readLine().toCharArray().map(Char::digitToInt) }
        V = B.sumOf { it.count { v -> v == 1 } }
        bruteforce(0, 0)
        print(answer)
    }
}