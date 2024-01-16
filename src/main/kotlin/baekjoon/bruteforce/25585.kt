package baekjoon.bruteforce

import kotlin.math.absoluteValue

class `25585` {
    private data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
        val kill: Int = 0,
    )

    private var N = 0
    private lateinit var B: List<List<Int>>
    private val T = mutableListOf<Loc>()
    private lateinit var S: Loc
    private lateinit var visited: BooleanArray
    private var answer = Int.MAX_VALUE

    private fun dfs(x: Int, y: Int, cnt: Int, kill: Int) {
        if (kill == T.size) {
            answer = minOf(answer, cnt)
            return
        }

        for (i in T.indices) {
            if (visited[i].not()) {
                visited[i] = true
                dfs(
                    T[i].x, T[i].y,
                    cnt + maxOf((x - T[i].x).absoluteValue, (y - T[i].y).absoluteValue),
                    kill + 1
                )
                visited[i] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        B = List(N) { readLine().split(" ").map(String::toInt) }
            .also {
                for (i in 0 until N) {
                    for (j in 0 until N) {
                        if (it[i][j] == 1) {
                            T.add(Loc(i, j))
                        } else if (it[i][j] == 2) {
                            S = Loc(i, j)
                        }
                    }
                }
            }
        visited = BooleanArray(T.size) { false }

        // 절대 못 만나는 위치 파악
        for (t in T) {
            if ((S.x % 2 == S.y % 2) != (t.x % 2 == t.y % 2)) {
                print("Shorei")
                return
            }
        }

        dfs(S.x, S.y, 0, 0)
        if (answer != Int.MAX_VALUE) {
            print("Undertaker\n$answer")
        } else {
            print("Shorei")
        }
    }
}