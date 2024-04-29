package baekjoon.graph

import java.util.BitSet

class `3055` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
    )

    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (R, C) = readLine().split(" ").map(String::toInt)
        val q = ArrayDeque<Loc>()
        var D: Loc? = null
        val W = List(R) { IntArray(C) { Int.MAX_VALUE } }
        var w = mutableListOf<Loc>()
        val B = List(R) { r ->
            readLine().also {
                it.forEachIndexed { i, c ->
                    when (c) {
                        'S' -> q.add(Loc(r, i))
                        'D' -> D = Loc(r, i)
                        '*' -> {
                            W[r][i] = 0
                            w.add(Loc(r, i))
                        }
                    }
                }
            }
        }

        // 물 기록
        while (w.isNotEmpty()) {
            val next = mutableListOf<Loc>()
            for ((x, y) in w) {
                for ((dx, dy) in d) {
                    val (nx, ny) = x + dx to y + dy
                    if (nx in 0 until R && ny in 0 until C) {
                        if (W[x][y] + 1 < W[nx][ny] && B[nx][ny] == '.') {
                            W[nx][ny] = W[x][y] + 1
                            next.add(Loc(nx, ny))
                        }
                    }
                }
            }
            w = next
        }

        val V = BitSet()
        while (q.isNotEmpty()) {
            val (x, y, cnt) = q.removeFirst()
            if (x == D?.x && y == D?.y) {
                print(cnt)
                return
            }

            for ((dx, dy) in d) {
                val (nx, ny) = x + dx to y + dy
                if (nx in 0 until R && ny in 0 until C) {
                    if (B[nx][ny] != 'X' && cnt + 1 < W[nx][ny] && V.get(nx * C + ny).not()) {
                        V.set(nx * C + ny)
                        q.add(Loc(nx, ny, cnt + 1))
                    }
                }
            }
        }
        print("KAKTUS")
    }
}