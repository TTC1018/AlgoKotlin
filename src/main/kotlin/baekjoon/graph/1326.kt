package baekjoon.graph

import java.util.LinkedList
import java.util.Queue

class `1326` {

    data class Pos(
        val now: Int,
        val count: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val bridge = readLine().trim().split(" ").map { it.toInt() }
        var (a, b) = readLine().trim().split(" ").map { it.toInt() - 1 }

        val q: Queue<Pos> = LinkedList()
        val visited = BooleanArray(N) { false }
        q.add(Pos(a, 0))
        visited[a] = true

        while (q.isNotEmpty()) {
            val (now, count) = q.remove()
            if (now == b) {
                println(count)
                return
            }

            for (i in now until N step bridge[now]) {
                if (visited[i].not()) {
                    visited[i] = true
                    q.add(Pos(i, count + 1))
                }
            }
            for (i in now downTo  0 step bridge[now]) {
                if (visited[i].not()) {
                    visited[i] = true
                    q.add(Pos(i, count + 1))
                }
            }
        }

        println(-1)
    }

}

fun main() {

    `1326`().solution()

}