package baekjoon.bruteforce

class `2210` {
    private data class Loc(
        val x: Int,
        val y: Int,
    )

    private lateinit var B: List<List<Int>>
    private val sb = StringBuilder()
    private val answer = mutableSetOf<String>()
    private val d = listOf(Loc(1, 0), Loc(-1, 0), Loc(0, 1), Loc(0, -1))

    private fun bruteforce(x: Int, y: Int, cnt: Int) {
        if (cnt == 6) {
            answer.add(sb.toString())
            return
        }

        for ((dx, dy) in d) {
            val (nx, ny) = x + dx to y + dy
            if (nx in 0 until 5 && ny in 0 until 5) {
                sb.append(B[nx][ny])
                bruteforce(nx, ny, cnt + 1)
                sb.deleteAt(sb.length - 1)
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        B = List(5) { readLine().split(" ").map(String::toInt) }
        for (i in 0 until 5) {
            for (j in 0 until 5) {
                sb.append(B[i][j])
                bruteforce(i, j, 1)
                sb.deleteAt(0)
            }
        }

        print(answer.size)
    }
}