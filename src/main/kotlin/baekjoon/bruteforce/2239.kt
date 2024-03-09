package baekjoon.bruteforce

import kotlin.system.exitProcess

class `2239` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private lateinit var B: List<IntArray>
    private val Z = mutableListOf<Loc>()

    private fun bruteforce(idx: Int) {
        if (idx == Z.size) {
            print(B.joinToString("\n") { it.joinToString("") })
            exitProcess(0)
        }

        val cands = (1..9).toMutableSet()
        val (x, y) = Z[idx]

        // 행, 열 체크
        for (i in 0 until 9) {
            cands.remove(B[x][i])
            cands.remove(B[i][y])
        }
        // 9칸 체크
        val sx = x.div(3).times(3)
        val sy = y.div(3).times(3)
        for (i in sx until sx + 3) {
            for (j in sy until sy + 3) {
                cands.remove(B[i][j])
            }
        }

        for (cand in cands) {
            B[x][y] = cand
            bruteforce(idx + 1)
        }
        B[x][y] = 0
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        B = List(9) { readLine().map(Char::digitToInt).toIntArray() }
        B.forEachIndexed { i, row -> row.forEachIndexed { j, v -> if (v == 0) Z.add(Loc(i, j)) } }
        bruteforce(0)
    }
}