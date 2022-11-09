package baekjoon.bruteforce

import kotlin.math.max
import kotlin.math.sqrt

class `1025` {


    private var answer = -1

    private fun isSquare(num: Int): Boolean {
        val numSqrt = sqrt(num.toDouble())
        return numSqrt % 1 == 0.0
    }

    private fun check(temp: StringBuilder) {
        val tempInt = temp.toString().toInt()
        if (isSquare(tempInt))
            answer = max(answer, tempInt)
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, M) = readLine().split(" ").map { it.toInt() }
        val graph = List(N) { readLine().trim() }
        val rowStep = (-N until N)
        val colStep = (-M until M)

        for (i in 0 until N) {
            for (j in 0 until M) {
                rowStep.forEach { x ->
                    colStep.forEach { y ->
                        var temp = StringBuilder()
                        var nx = i; var ny = j
                        while (nx in 0 until N && ny in 0 until M) {
                            temp.append(graph[nx][ny])
                            if (x == 0 && y == 0)
                                break
                            check(temp)
                            nx += x; ny += y
                        }
                    }
                }
            }
        }

        print(answer)
    }

}

fun main() {

    `1025`().solution()

}