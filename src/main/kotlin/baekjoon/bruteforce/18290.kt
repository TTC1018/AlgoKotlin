package baekjoon.bruteforce

class `18290` {
    private data class Step(
        val x: Int,
        val y: Int,
    )

    private var N = 0
    private var M = 0
    private var K = 0
    private lateinit var B: List<List<Int>>
    private lateinit var visited: List<BooleanArray>
    private var total = 0
    private var answer = Int.MIN_VALUE

    private val d = listOf(
        Step(1, 0), Step(-1, 0), Step(0, 1), Step(0, -1)
    )

    private fun check(x: Int, y: Int): Boolean {
        for ((dx, dy) in d) {
            val (nx, ny) = x + dx to y + dy
            if (nx in 0 until N && ny in 0 until M && visited[nx][ny]) {
                return false
            }
        }
        return true
    }

    private fun bruteforce(x: Int, y: Int, cnt: Int) {
        if (cnt == K) {
            answer = maxOf(answer, total)
            return
        }

        for (nx in x until N) {
            for (ny in 0 until M) {
                if (visited[nx][ny].not() && check(nx, ny)) {
                    visited[nx][ny] = true
                    total += B[nx][ny]
                    bruteforce(nx, ny, cnt + 1)
                    visited[nx][ny] = false
                    total -= B[nx][ny]
                }
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            N = first(); M = this[1]; K = last()
        }

        B = List(N) { readLine().split(" ").map(String::toInt) }
        visited = List(N) { BooleanArray(M) { false } }
        bruteforce(0, 0, 0)
        print(answer)
    }
}