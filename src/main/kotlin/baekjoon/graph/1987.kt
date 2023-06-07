package baekjoon.graph

import kotlin.math.max

class `1987` {

    data class Loc(
        val x: Int,
        val y: Int,
        val cnt: Int = 0,
        val bit: Int = 0
    )

    private fun Char.toBit() = this - 'A'

    private var R = 0
    private var C = 0
    private var bit = 0
    private lateinit var B: Array<CharArray>
    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))
    private var answer = 0

    private fun search(x: Int, y: Int, cnt: Int) {
        answer = max(answer, cnt)

        for ((dx, dy) in d) {
            val nx = x + dx
            val ny = y + dy

            if (nx in 0 until R && ny in 0 until C) {
                val alpha = 1 shl B[nx][ny].toBit()
                if (bit and alpha == 0) {
                    bit = bit or alpha
                    search(nx, ny, cnt + 1)
                    bit = bit xor alpha
                }
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { R = it[0]; C = it[1] }
        B = Array(R) { readLine().toCharArray() }
        bit = bit or (1 shl B[0][0].toBit())

        search(0, 0, 1)
        print(answer)
    }

}

fun main() {

    `1987`().solution()

}