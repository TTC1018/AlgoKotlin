package baekjoon.implementation

class `4179` {

    data class Loc(
        val x: Int,
        val y: Int
    )

    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))
    private var R = 0
    private var C = 0
    private lateinit var B: Array<CharArray>
    private var q = mutableSetOf<Loc>()
    private var fires = mutableSetOf<Loc>()
    private lateinit var visited: Array<BooleanArray>
    private lateinit var inRange: (Int, Int) -> Boolean

    private fun spreadFire() {
        val nexts = mutableSetOf<Loc>()

        fires.forEach { (x, y) ->
            d.forEach { (dx, dy) ->
                val nx = x + dx
                val ny = y + dy
                if (inRange(nx, ny) && B[nx][ny] == '.') {
                    val next = Loc(nx, ny)
                    if (next in q)
                        q.remove(next)
                    nexts.add(next)
                }
            }
        }

        for ((x, y) in nexts) {
            B[x][y] = 'F'
        }

        fires = nexts
    }

    private fun inputs() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also {
                R = it.first(); C = it.last()
            }
        B = Array(R) { charArrayOf() }
        visited = Array(R) { BooleanArray(C) { false } }
        inRange = { x, y -> x in 0 until R && y in 0 until C }
        repeat(R) { i ->

            readLine().toCharArray()
                .also {
                    for (j in 0 until C) {
                        when (it[j]) {
                            'J' -> {
                                q.add(Loc(i, j))
                                visited[i][j] = true
                            }

                            'F' -> fires.add(Loc(i, j))
                        }
                    }

                    B[i] = it
                }

        }

    }

    fun solution() {

        inputs()
        var sec = 0
        while (q.isNotEmpty()) {
            val nexts = mutableSetOf<Loc>()
            sec += 1

            for ((x, y) in q) {
                for ((dx, dy) in d) {
                    val nx = x + dx
                    val ny = y + dy

                    if (inRange(nx, ny)) {
                        if (visited[nx][ny].not() && B[nx][ny] == '.') {
                            visited[nx][ny] = true
                            nexts.add(Loc(nx, ny))
                        }
                    } else {
                        print(sec)
                        return
                    }
                }
            }
            q = nexts
            spreadFire()
        }

        print("IMPOSSIBLE")
    }

}

fun main() {

    `4179`().solution()

}