package baekjoon.implementation

import kotlin.math.pow

class `21608` {
    private data class Loc(
        val x: Int,
        val y: Int,
    ) : Comparable<Loc> {
        override fun compareTo(other: Loc): Int {
            if (x == other.x)
                return y.compareTo(other.y)
            return x.compareTo(other.x)
        }
    }

    private data class Counter(
        var nearby: Int,
        var empty: Int,
    )

    private val d = listOf(
        Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1)
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val G = List(N) { IntArray(N) }
        val F = mutableMapOf<Int, Set<Int>>()
        repeat(N * N) {
            val stuAndOthers = readLine().split(" ").map(String::toInt)
            val stu = stuAndOthers.first()
            F[stu] = stuAndOthers.drop(1).toSet()
            val cands = mutableMapOf<Loc, Counter>()
            for (i in G.indices) {
                for (j in G.indices) {
                    if (G[i][j] == 0) {
                        cands[Loc(i, j)] = Counter(0, 0)
                        for ((dx, dy) in d) {
                            val (nx, ny) = i + dx to j + dy
                            if (nx in 0 until N && ny in 0 until N) {
                                if (G[nx][ny] == 0) {
                                    cands[Loc(i, j)]!!.empty++
                                } else if (G[nx][ny] in F[stu]!!) {
                                    cands[Loc(i, j)]!!.nearby++
                                }
                            }
                        }
                    }
                }
            }

            cands.keys.sortedWith(
                compareBy(
                    { -cands[it]!!.nearby },
                    { -cands[it]!!.empty },
                    { it }
                )
            ).firstOrNull()?.run {
                G[x][y] = stu
            }
        }

        var answer = 0
        for (i in G.indices) {
            for (j in G.indices) {
                val stu = G[i][j]
                var temp = 0
                for ((dx, dy) in d) {
                    val (nx, ny) = i + dx to j + dy
                    if (nx in 0 until N && ny in 0 until N) {
                        if (G[nx][ny] in F[stu]!!)
                            temp++
                    }
                }

                answer += (10.0).pow(temp - 1).toInt()
            }
        }
        print(answer)
    }
}