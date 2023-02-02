package baekjoon

import kotlin.math.min

class `15683` {

    data class CCTV(
        val x: Int,
        val y: Int,
        val value: Int
    )

    data class Pos(
        val x: Int,
        val y: Int
    )

    private val d = listOf(
        Pos(-1, 0), Pos(1, 0),
        Pos(0, -1), Pos(0, 1)
    )

    private val dMap = mapOf(
        1 to arrayOf(
            intArrayOf(0), intArrayOf(1),
            intArrayOf(2), intArrayOf(3)
        ),
        2 to arrayOf(
            intArrayOf(0, 1), intArrayOf(2, 3)
        ),
        3 to arrayOf(
            intArrayOf(0, 3), intArrayOf(0, 2),
            intArrayOf(1, 2), intArrayOf(1, 3)
        ),
        4 to arrayOf(
            intArrayOf(0, 2, 3), intArrayOf(0, 1, 2),
            intArrayOf(0, 1, 3), intArrayOf(1, 2, 3)
        ),
        5 to arrayOf(intArrayOf(0, 1, 2, 3))
    )

    private var N = 0
    private var M = 0
    private val inRange: (Int, Int) -> Boolean = { x, y ->
        x in 0 until N && y in 0 until M
    }
    private lateinit var board: Array<IntArray>
    private val cctv = mutableListOf<CCTV>()
    private var answer = Int.MAX_VALUE


    private fun calc(graph: Array<IntArray>): Int {
        var sumVal = 0
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (graph[i][j] == 0)
                    sumVal++
            }
        }

        return sumVal
    }

    private fun paint(x: Int, y: Int, direc: Int, graph: Array<IntArray>) {
        val (dx, dy) = d[direc]
        var sx = x + dx
        var sy = y + dy

        // # 처리
        while (inRange(sx, sy)) {
            when (graph[sx][sy]) {
                0 -> graph[sx][sy] = -1
                6 -> break
            }
            sx += dx
            sy += dy
        }
    }

    private fun bruteforce(idx: Int, limit: Int, graph: Array<IntArray>) {
        if (idx == limit) {
            answer = min(answer, calc(graph))
            return
        }

        val (x, y, value) = cctv[idx]
        dMap[value]!!.forEach {
            val graphCpy = Array(N) { i -> graph[i].clone() }
            it.forEach { direc ->
                paint(x, y, direc, graphCpy)
            }
            bruteforce(idx + 1, limit, graphCpy)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }.also {
            N = it.first()
            M = it.last()
        }

        board = Array(N) { i ->
            readLine().split(" ").map { it.toInt() }.toIntArray()
                .also { row ->
                    row.forEachIndexed { j, v ->
                        if (v != 0 && v != 6)
                            cctv.add(CCTV(i, j, v))
                    }
                }
        }

        bruteforce(0, cctv.size, board)

        print(answer)
    }

}

fun main() {

    `15683`().solution()

}