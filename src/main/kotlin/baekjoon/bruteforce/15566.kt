package baekjoon.bruteforce

import kotlin.system.exitProcess

class `15566` {
    private data class Route(
        val a: Int,
        val b: Int,
    )

    private var N = 0
    private var M = 0
    private lateinit var F: List<List<Int>>
    private lateinit var T: Map<Route, Int>
    private lateinit var L: List<Set<Int>>
    private lateinit var answer: IntArray
    private lateinit var visited: BooleanArray

    private fun check(): Boolean {
        for ((k, v) in T) {
            val (a, b) = k
            if (F[answer[a]][v] != F[answer[b]][v])
                return false
        }

        return true
    }

    private fun bruteforce(now: Int) {
        if (now == N) {
            if (check()) {
                println("YES")
                print(answer.joinToString(" ") { (it+1).toString() })
                exitProcess(0)
            }
            return
        }

        for (i in 0 until N) {
            if (visited[i].not() && now in L[i]) {
                visited[i] = true
                answer[now] = i
                bruteforce(now + 1)
                answer[now] = -1
                visited[i] = false
            }
        }
    }

    fun main() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = last()
        }
        answer = IntArray(N)
        visited = BooleanArray(N) { false }
        F = List(N) { readLine().split(" ").map(String::toInt) }
        L = List(N) { buildSet { addAll(readLine().split(" ").map { it.toInt() - 1 }) } }
        T = buildMap {
            repeat(M) {
                readLine().split(" ").map { it.toInt() - 1 }.let {
                    put(Route(it[0], it[1]), it[2])
                }
            }
        }

        bruteforce(0)
        print("NO")
    }
}