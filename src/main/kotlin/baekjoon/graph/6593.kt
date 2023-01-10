package baekjoon.graph

import kotlin.math.min

class `6593` {

    private var answer = Int.MAX_VALUE

    data class Pos(
        val z: Int,
        val x: Int,
        val y: Int,
        val count: Int = 0
    )

    private val d = arrayOf(
        Pos(0, 0, 1), Pos(0, 0, -1),
        Pos(0, -1, 0), Pos(0, 1, 0),
        Pos(1, 0, 0), Pos(-1, 0, 0)
    )

    private fun findStart(L:Int, R:Int, C:Int, graph:List<List<CharArray>>): Pos {

        for (i in 0 until L) {
            for (j in 0 until R) {
                for (k in 0 until C) {
                    if (graph[i][j][k] == 'S')
                        return Pos(i, j, k)
                }
            }
        }

        return Pos(-1, -1, -1)
    }

    private fun bfs(start: Pos, L:Int, R:Int, C:Int, graph:List<List<CharArray>>){

        val visited = Array(L) { Array(R) { BooleanArray(C) { false } } }
        val q = ArrayDeque<Pos>().apply { add(start) }

        while (q.isNotEmpty()){
            val (z, x, y, cnt) = q.removeFirst()
            if (graph[z][x][y] == 'E'){
                answer = min(answer, cnt)
                continue
            }

            d.forEach { (dz, dx, dy) ->
                val nz = z + dz
                val nx = x + dx
                val ny = y + dy

                if (nz in 0 until L && nx in 0 until R && ny in 0 until C){
                    if (visited[nz][nx][ny].not() && graph[nz][nx][ny] != '#'){
                        visited[nz][nx][ny] = true
                        q.add(Pos(nz, nx, ny, cnt + 1))
                    }
                }
            }
        }

    }


    fun solution() = with(System.`in`.bufferedReader()) {

        while (true) {

            answer = Int.MAX_VALUE

            val (L, R, C) = readLine().split(" ").map { it.toInt() }
            if (L == 0 && R == 0 && C == 0)
                break

            val graph = List(L) {
                mutableListOf<CharArray>().apply {
                    repeat(R) {
                        add(readLine().toCharArray())
                    }
                    readLine()
                }
            }

            val S = findStart(L, R, C, graph)

            bfs(S, L, R, C, graph)

            if (answer != Int.MAX_VALUE)
                println("Escaped in $answer minute(s).")
            else
                println("Trapped!")
        }

    }

}

fun main() {

    `6593`().solution()

}