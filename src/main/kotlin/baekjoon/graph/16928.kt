package baekjoon.graph

import kotlin.math.min

class `16928` {

    data class Pos(
        val x: Int,
        val y: Int,
        val cnt: Int = 0
    ) {
        operator fun plus(num: Int) = Pos(x, y, cnt + num)
    }



    fun solution() = with(System.`in`.bufferedReader()){

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val numToPos: (Int) -> Pos = { num -> Pos((num-1) / 10, (num-1) % 10) }
        val posToNum: (Pos) -> Int = { pos -> pos.x * 10 + pos.y + 1 }
        val visited = BooleanArray(100 + 1) { false }
        val events = buildSet {
            repeat(N + M){
                add(readLine().split(" ").map { it.toInt() }.run { Pos(first(), last()) } )
            }
        }

        val q = ArrayDeque<Pos>().apply {
            add(Pos(0, 0))
            visited[1] = true
        }

        while (q.isNotEmpty()){
            val pos = q.removeFirst()
            val num = posToNum(pos)
            val cnt = pos.cnt

            if (num == 100){
                print(cnt)
                return
            }

            for (i in 6 downTo 1){
                val next = min(num + i, 100)
                val event = events.find { next == it.x }
                val dest = event?.y ?: next

                if (visited[dest].not()){
                    visited[dest] = true
                    q.add(numToPos(dest) + cnt + 1)
                }
            }
        }


    }

}

fun main() {

    `16928`().solution()

}