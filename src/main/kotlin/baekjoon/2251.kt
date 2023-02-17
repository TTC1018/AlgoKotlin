package baekjoon

import kotlin.math.min

class `2251` {

    data class Water(
        val a:Int,
        val b:Int,
        val c:Int
    )

    fun solution() = with(System.`in`.bufferedReader()){

        val (A, B, C) = readLine().split(" ").map { it.toInt() }
        val visited = Array(A + 1) { Array(B + 1) { BooleanArray(C + 1) { false } } }
            .also { it[0][0][C] = true }
        val q = ArrayDeque<Water>().apply { add(Water(0, 0, C)) }
        val answers = mutableSetOf(C)

        while (q.isNotEmpty()){
            val (a, b, c) = q.removeFirst()
            if (a == 0)
                answers.add(c)

            val aToB = min(a, B - b)
            if (visited[a - aToB][b + aToB][c].not()){
                visited[a - aToB][b + aToB][c] = true
                q.add(Water(a - aToB, b + aToB, c))
            }

            val aToC = min(a, C - c)
            if (visited[a - aToC][b][c + aToC].not()){
                visited[a - aToC][b][c + aToC] = true
                q.add(Water(a - aToC, b, c + aToC))
            }

            val bToA = min(b, A - a)
            if (visited[a + bToA][b - bToA][c].not()){
                visited[a + bToA][b - bToA][c] = true
                q.add(Water(a + bToA, b - bToA, c))
            }

            val bToC = min(b, C - c)
            if (visited[a][b - bToC][c + bToC].not()){
                visited[a][b - bToC][c + bToC] = true
                q.add(Water(a, b - bToC, c + bToC))
            }

            val cToA = min(c, A - a)
            if (visited[a + cToA][b][c - cToA].not()){
                visited[a + cToA][b][c - cToA] = true
                q.add(Water(a + cToA, b, c - cToA))
            }

            val cToB = min(c, B - b)
            if (visited[a][b + cToB][c - cToB].not()){
                visited[a][b + cToB][c - cToB] = true
                q.add(Water(a, b + cToB, c - cToB))
            }

        }

        print(answers.sorted().joinToString(" "))
    }

}

fun main(){

    `2251`().solution()

}