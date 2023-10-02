package baekjoon.math

class `2485` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val D = List(N) { readLine().toInt() }
            .zipWithNext()
            .map { (p, n) -> n - p }

        val minDist = D.reduce { acc, d ->
            var (a, b) = acc to d
            while (b != 0) {
                val (newA, newB) = b to a % b
                a = newA
                b = newB
            }
            a
        }

        print(D.sumOf { it.div(minDist) - 1 })
    }
}

fun main() {
    `2485`().solution()
}