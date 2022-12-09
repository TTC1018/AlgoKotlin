package baekjoon.graph

class `2668` {

    private lateinit var secondLine: IntArray
    private lateinit var candidates: BooleanArray

    private fun search(origin: Int, now: Int, visited: MutableSet<Int>) {
        if (origin == now) {
            candidates[origin] = true
            return
        }
        if (now in visited)
            return

        visited.add(now)
        val next = secondLine[now]
        search(origin, next, visited)

    }

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        candidates = BooleanArray(N) { false }
        secondLine = IntArray(N) { readLine().toInt() - 1 }

        (0 until N).forEach { idx ->
            search(idx, secondLine[idx], mutableSetOf(idx))
        }

        val answers = (0 until N).filter { candidates[it] }
        println(answers.size)
        print(answers.map { it + 1 }.joinToString("\n"))
    }

}

fun main() {

    `2668`().solution()

}